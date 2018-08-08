package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ Create by ostreamBaba on 18-6-25
 * @ √Ë ˆ
 */

@Entity
public class CarUser {

    @Id
    @GeneratedValue
    private Integer carId;

    private String carUsername;

    private String carPassword;

    private String email;

    public CarUser() {
        super();
    }

    public CarUser(String carUsername, String carPassword, String email) {
        this.carUsername = carUsername;
        this.carPassword = carPassword;
        this.email = email;
    }

    public String getCarUsername() {
        return carUsername;
    }

    public String getCarPassword() {
        return carPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setCarUsername(String carUsername) {
        this.carUsername = carUsername;
    }

    public void setCarPassword(String carPassword) {
        this.carPassword = carPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }


}
