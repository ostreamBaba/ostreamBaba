package com.ostream.springmvc4.domain;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
public class DemoObj {

    private Long id;
    private String name;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
