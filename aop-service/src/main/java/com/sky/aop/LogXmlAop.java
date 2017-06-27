package com.sky.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by gantianxing on 2017/6/26.
 */
@Component
public class LogXmlAop {
    private static final Log log = LogFactory.getLog(LogAop.class);

    //前置通知
    public void beforeLog(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName()+"类的"+jp.getSignature().getName()+ "方法Before日志");
    }

    //环绕通知
    public void aroundLog(ProceedingJoinPoint jp) {
        try {
            log.info(jp.getSignature().getDeclaringTypeName()+"类的"+jp.getSignature().getName()+"方法Around通知开始");
            jp.proceed();
            log.info(jp.getSignature().getDeclaringTypeName() + "方法Around通知结束");
        }catch (Throwable throwable) {
            Object[] args = jp.getArgs();

            System.out.println("参数列表值为：");
            for (Object one: args){
                log.error(one.toString());
            }
            log.error(jp.getSignature().getDeclaringTypeName() + "类的" + jp.getSignature().getName() + "调用异常", throwable);

        }

    }

    //后置通知
    public void after(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName()+"类的"+jp.getSignature().getName()+  "方法after日志");
    }

    //返回通知
    public void afterRet(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName()+"类的"+jp.getSignature().getName()+ "方法AfterReturning日志");
    }

    //异常通知
    public void afterError(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName()+"类的"+jp.getSignature().getName()+ "方法AfterThrowing日志");
    }
}
