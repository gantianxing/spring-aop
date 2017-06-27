package com.sky.aop.service.product.impl;

import com.sky.aop.service.product.ProductService;
import org.springframework.stereotype.Component;

/**
 * Created by gantianxing on 2017/6/23.
 */
@Component
public class ProductServiceImpl implements ProductService{
    @Override
    public void add(int id) {
        System.out.println("ProductService的add方法调用，参数为:"+id);
    }
}
