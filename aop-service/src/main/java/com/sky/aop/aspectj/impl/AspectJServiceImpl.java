package com.sky.aop.aspectj.impl;

import com.sky.aop.aspectj.AspectJService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by gantianxing on 2017/6/26.
 */
@Component
public class AspectJServiceImpl implements AspectJService{
    private static final Log log = LogFactory.getLog(AspectJServiceImpl.class);

    public AspectJServiceImpl(){
        log.info("AspectJServiceImpl构造方法执行");
    }

    @Override
    public void run() {
        log.info("AspectJService run方法执行");
    }
}
