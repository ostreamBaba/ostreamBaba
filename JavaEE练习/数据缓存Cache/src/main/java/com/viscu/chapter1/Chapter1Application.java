package com.viscu.chapter1;

import com.viscu.chapter1.dao.PersonRepository;
import com.viscu.chapter1.support.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableCaching
public class Chapter1Application {
	@Autowired
	PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
}
