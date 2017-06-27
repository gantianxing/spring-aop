package com.sky.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by gantianxing on 2017/6/26.
 */
public aspect MyAspectJ {

    private static final Log log = LogFactory.getLog(MyAspectJ.class);

    public MyAspectJ(){}

    //定义构造方法调用切面
    pointcut newCreate():execution(com.sky.aop.aspectj.impl.AspectJServiceImpl.new());

    Object around():newCreate(){
        log.info("调用构造方法开始");
        Object result = proceed();
        log.info("调用构造方法结束");
        return result;
    }

    //定义普通方法调用切面
    pointcut runLog():execution(* com.sky.aop.aspectj.impl.AspectJServiceImpl.run());
    before():runLog(){
        log.info("调用普通方法前打印日志");
    }

}
