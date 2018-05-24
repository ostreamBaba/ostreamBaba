package com.viscu.chapter1.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterators.toArray;

/**
 * @ Create by ostreamBaba on 18-5-24
 * @ 结合Specification和自定义Repository实现自动模糊查询
 * 对任意的实体进行查询 对象里有几个值 就查几个值 当字符型就自动进行like查询 没有值就查询全部
 */

public class CustomerSpecs {
    //定义一个返回值为Spcification的方法ByAuto
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example){
        @SuppressWarnings("unchecked")
        final Class<T> type=(Class<T>)example.getClass(); //获得实体对象的类型
        return new Specification<T>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates=new ArrayList<Predicate>(); //存储构造的查询条件
                EntityType<T> entityType=entityManager.getMetamodel().entity(type);
                //获得实体类的EntityType 可以从中获得实体类的属性
                for (Attribute<T,?>attr: entityType.getDeclaredAttributes()){ //对实体类的所有属性做循环
                    Object attrValue=getValue(example,attr); //获得实体类对象的某一个属性
                    if(attrValue!=null){
                        if(attr.getJavaType()==String.class){//当前属性为字符串类型
                            if(!StringUtils.isEmpty(attrValue)){ //当字符串不为空
                                predicates.add(criteriaBuilder.like(root.get(attribute(entityType,attr.getName(),String.class)),
                                    pattern((String)attrValue)));
                                //构造当前属性like(前后%)属性值查询条件 并添加到列表当中
                            }
                        }else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entityType,attr.getName(),attrValue.getClass())),
                                    attrValue)); //其他情况下 构造属性和属性值equal
                        }
                    }
                }
                return predicates.isEmpty()?criteriaBuilder.conjunction():criteriaBuilder.and(toArray(predicates.iterator(),Predicate.class)); //将条件列表转化成为Predicate
            }
            /*
             *  通过反射获得实体类对象对象属性的属性值
             */
            private <T> Object getValue(T example,Attribute<T,?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(),example);
            }
            /*
             * 获得实体类的当前属性的SingularAttribute(包含实体类的某个单独属性)
             */
            private <T,E> SingularAttribute<T,E> attribute(EntityType<T> entityType,String fieldName,
                                                           Class<E> fieldClass){
                return entityType.getDeclaredSingularAttribute(fieldName,fieldClass);
            }

        };
    }
    /*
        构造like查询模式 即前后加%  %xxx%
     */
    static private String pattern(String str){
        return "%"+str+"%";
    }
}
