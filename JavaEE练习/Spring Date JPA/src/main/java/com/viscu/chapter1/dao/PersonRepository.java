package com.viscu.chapter1.dao;

import com.viscu.chapter1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sang on 2016/12/30.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
    /*
     * 通过地址进行查询，参数为address,
     * 相当于JPQL：select p from Person p where p.address=?1
     */

    List<Person> findByAddress(String name);
    /*
     * 通过地址和名字进行查询，参数为name,address
     * 相当于JPQL：select p from Person p where p.name=?1 and address=?2
     */
    Person findByNameAndAddress(String name, String address);
    @Query("select p from Person p where p.name=:name and p.address=:address")//根据名称来查询
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
    //根据索引来查询
    Person withNameAndAddressNamedQuery(String name, String address);
}
