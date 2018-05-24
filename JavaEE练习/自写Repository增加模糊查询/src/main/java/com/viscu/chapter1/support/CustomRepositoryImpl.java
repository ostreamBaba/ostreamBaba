package com.viscu.chapter1.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.viscu.chapter1.specs.CustomerSpecs.byAuto;

/**
 * @ Create by ostreamBaba on 18-5-24
 * @ 描述
 */
@NoRepositoryBean
public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {
    private final EntityManager entityManager;
    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super( domainClass, entityManager);
        this.entityManager = entityManager;
    }
    @Override
    public Page<T> findByAuto(T example, Pageable pageable){
        return findAll(byAuto(entityManager,example),pageable);
    }
}



