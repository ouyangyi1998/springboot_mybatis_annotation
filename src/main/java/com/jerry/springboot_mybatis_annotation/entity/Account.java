package com.jerry.springboot_mybatis_annotation.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private int id;
    private String name;
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
