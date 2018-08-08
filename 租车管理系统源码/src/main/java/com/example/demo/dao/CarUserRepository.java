package com.example.demo.dao;

import com.example.demo.domain.CarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ Create by ostreamBaba on 18-6-25
 * @ √Ë ˆ
 */
public interface CarUserRepository extends JpaRepository<CarUser,Long>{

    CarUser save(CarUser carUser);

    CarUser findByCarUsername(String username);

    CarUser findByCarId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update car_user cu set cu.car_password=?1 where cu.car_username=?2",nativeQuery = true)
    int resetPasswordByName(String password,String name);

    @Transactional
    @Modifying
    @Query(value = "update car_user cu set cu.car_username=?1 where cu.car_id=?2",nativeQuery = true)
    int changeUsernameByName(String name,Integer id);
}
