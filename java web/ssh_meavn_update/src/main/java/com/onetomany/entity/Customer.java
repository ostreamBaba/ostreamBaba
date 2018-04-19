package com.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */

public class Customer {

    private Integer id;
    private String name;
    private Set<Order> orders=new HashSet<Order>();


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
