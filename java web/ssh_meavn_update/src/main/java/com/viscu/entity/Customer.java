package com.viscu.entity;

/**
 * @Create by ostreamBaba on 18-3-30
 * @√Ë ˆ
 */
public class Customer {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String city;

    public Customer() {
        super();
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer: [id="+id+
                ",name="+name+
                ",age="+age+
                ",sex="+sex+
                ",city="+city+"]";
    }
}
