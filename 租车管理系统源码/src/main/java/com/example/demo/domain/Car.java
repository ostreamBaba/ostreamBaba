package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ Create by ostreamBaba on 18-6-25
 * @ 描述
 */


@Entity
public class Car{

    @Id
    @GeneratedValue
    private Integer carId;

    private String carType; //汽车类型

    private Integer carPrice; //汽车价格

    private String carBrand; //汽车品牌

    private String carName;//汽车名字

    private Integer carIsRent; //是否被租借

    public Car() {
        super();
    }

    public Car(String carType, Integer carPrice, String carBrand, String carName, Integer carIsRent) {
        this.carType = carType;
        this.carPrice = carPrice;
        this.carBrand = carBrand;
        this.carName = carName;
        this.carIsRent = carIsRent;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getCarType() {
        return carType;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getCarIsRent() {
        return carIsRent;
    }

    public void setCarIsRent(Integer carIsRent) {
        this.carIsRent = carIsRent;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
