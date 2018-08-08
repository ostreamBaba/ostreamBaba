package com.example.demo.dao;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ √Ë ˆ
 */
public interface CarRepository extends JpaRepository<Car,Long>{

    Car findByCarId(Integer id);

    Car save(Car car);

    @Query(value = "select c.car_is_rent from car c WHERE c.car_id=?1",nativeQuery = true)
    Integer findIsRentById(Integer id);

    @Query(value = "select * from car",nativeQuery = true)
    List<Car> getAll();
/*
    @Query(value = "select * from car c where c.car_type=?1 AND c.car_brand=?2 AND c.car_price BETWEEN " +
            "?3 AND ?4",nativeQuery = true)
    List<Car> getCar(String carType,String carBrand,Integer start,Integer end);

    @Query(value = "select * from car c where c.car_type=?1 AND c.car_brand=?2 AND c.car_price > ?3",nativeQuery = true)
    List<Car> getCarPlus(String carType,String carBrand,Integer start);*/

    /*@Query(value = "select * from car c where ",nativeQuery = true)*/

    List<Car> findByCarPriceBetweenAndCarBrandAndCarIsRent(Integer start,Integer end,String carBrand,Integer isRent);

    List<Car> findByCarTypeAndCarBrandAndCarPriceBetweenAndCarIsRent(String carType,String carBrand,Integer start,Integer end,Integer isRent);

    List<Car> findByCarTypeAndCarBrandAndCarIsRent(String carType,String carBrand,Integer isRent);

    List<Car> findByCarTypeAndCarIsRent(String carType,Integer isRent);

    List<Car> findByCarBrandAndCarIsRent(String carType,Integer isRent);

    List<Car> findByCarPriceBetweenAndCarIsRent(Integer start,Integer end,Integer isRent);

    List<Car> findByCarTypeAndCarPriceBetweenAndCarIsRent(String carType,Integer start,Integer end,Integer isRent);

    List<Car> findByCarBrandAndCarPriceBetweenAndCarIsRent(String carBrand,Integer start,Integer end,Integer isRent);

    @Query(value = "select c.car_name from car c WHERE c.car_id=?1",nativeQuery = true)
    String getCarNameByCarId(Integer carId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE car c SET c.car_is_rent=?1 WHERE c.car_id=?2",nativeQuery = true)
    void updateIsRentById(Integer isRent,Integer id);

}
