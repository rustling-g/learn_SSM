package com.domain;

import java.io.Serializable;

/**
 * @author gg
 * @create 2020-11-23 15:28
 */
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Double money;

    public Account() {
    }

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
