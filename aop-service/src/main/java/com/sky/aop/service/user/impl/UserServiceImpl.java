package com.sky.aop.service.user.impl;

import com.sky.aop.service.User;
import com.sky.aop.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by gantianxing on 2017/6/23.
 */

@Component
public class UserServiceImpl implements UserService{
    private static final Random r = new Random();

    @Override
    public User add(User user,int flag) {
        inner();
        System.out.println("UserService的add方法调用");

        int x = r.nextInt(2);
        if(x==1){ //构造一个空指针异常
            String test = null;
            test.contains("123");
        }
        return user;
    }

    private void inner(){
        System.out.println("UserService的inner方法调用");
    }

}

