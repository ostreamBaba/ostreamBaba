package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ √Ë ˆ
 */

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Integer orderId;

    private String username;

    private String phoneNum;

    private String personId;

    private Integer day;

    private Integer price;

    private Integer adopt;

    private Integer orderUserId;

    private Integer orderCarId;

    private String orderCarName;

    public Orders() {
        super();
    }

    public Orders(String username, String phoneNum, String personId, Integer day, Integer price, Integer adopt, Integer orderUserId, Integer orderCarId, String orderCarName) {
        this.username = username;
        this.phoneNum = phoneNum;
        this.personId = personId;
        this.day = day;
        this.price = price;
        this.adopt = adopt;
        this.orderUserId = orderUserId;
        this.orderCarId = orderCarId;
        this.orderCarName = orderCarName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPersonId() {
        return personId;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAdopt() {
        return adopt;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAdopt(Integer adopt) {
        this.adopt = adopt;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Integer getOrderCarId() {
        return orderCarId;
    }

    public String getOrderCarName() {
        return orderCarName;
    }

    public void setOrderCarId(Integer orderCarId) {
        this.orderCarId = orderCarId;
    }

    public void setOrderCarName(String orderCarName) {
        this.orderCarName = orderCarName;
    }
}