package com.sky.aop.service.test;

import com.sky.aop.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gantianxing on 2017/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop.xml")
public class SpringAopXmlTest {

    @Autowired
    private ProductService productService;

    @Test
    public void productTest(){
        productService.add(1);
    }
}
