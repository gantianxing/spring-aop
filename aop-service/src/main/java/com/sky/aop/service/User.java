package com.sky.aop.service;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by gantianxing on 2017/6/8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;//姓名

    private String birthday;//生日

    private double money;//资产

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString(){
        return "用户信息 姓名："+name+" 生日："+birthday +" 资产："+money;
    }
}
