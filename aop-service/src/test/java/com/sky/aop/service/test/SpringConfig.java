package com.sky.aop.service.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by gantianxing on 2017/6/26.
 */
@ComponentScan(basePackages = "com.sky.aop")
@EnableAspectJAutoProxy
public class SpringConfig {
}
