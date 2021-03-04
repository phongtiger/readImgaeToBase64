package com.example.demov2;

import java.util.Date;

public class Customer {
    private Date createDate;
    private String name;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }
}
