package com.oneToMangTest;

import javax.persistence.*;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
@Entity
@Table(name = "customer_otm", schema = "MyStrugglle", catalog = "")
public class CustomerOtm {
    private int id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CustomerOtm that = (CustomerOtm) object;

        if (id != that.id) return false;
        if (name != null ? !name.equals( that.name ) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
