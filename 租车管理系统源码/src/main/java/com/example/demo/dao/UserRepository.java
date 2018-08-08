package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



public interface UserRepository extends JpaRepository<User,Long> {

     User save(User user);

     User findByName(String name);

     @Transactional
     @Modifying(clearAutomatically = true)
     @Query(value = "update user u set u.password=?1 where u.user_id=?2",nativeQuery = true)
     void updatePassword(String password,Long id);
}
