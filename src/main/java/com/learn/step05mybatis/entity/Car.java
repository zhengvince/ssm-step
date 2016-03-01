package com.learn.step05mybatis.entity;

import org.springframework.stereotype.Component;

/**
 * car
 * Created by Vince on 2016/2/22.
 */
@Component
public class Car {

    private Integer id;
    private String bland;
    private String color;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBland() {
        return bland;
    }

    public void setBland(String bland) {
        this.bland = bland;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
