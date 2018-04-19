package com.onetomany.entity;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Order {
    private Integer id;
    private String address;
    private Double price;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Customer: "+customer.getName()+": [id="+id
                +",address="+address
                +",price="+price
                +"]";
    }
}
