package com.viscu.chapter1.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @ Create by ostreamBaba on 18-5-24
 * @ 扩展方法
 */

@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T>{
    Page<T> findByAuto(T example, Pageable pageable);
}
