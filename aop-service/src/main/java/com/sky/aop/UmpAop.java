package com.sky.aop;

import com.jd.ump.profiler.CallerInfo;
import com.jd.ump.profiler.proxy.Profiler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by gantianxing on 2017/6/23.
 */
//@Component
//@Aspect
public class UmpAop {

    private static final Log log = LogFactory.getLog(UmpAop.class);

   // @Pointcut("execution(* com.sky.aop.service.*.*.*(..))")
    public void ump(){};

    //@Around("ump()")
    public void aroundLog(ProceedingJoinPoint jp) {
        CallerInfo info = null;
        String typeName = jp.getSignature().getDeclaringTypeName();
        String className = typeName.substring(typeName.lastIndexOf(".")+1);
        String methodName = jp.getSignature().getName();
        try {
            info = Profiler.registerInfo("spring-aop.service." + className + "." + methodName, "spring-aop", false, true);


            log.info(className+"类的"+methodName+"方法Around通知开始");
            jp.proceed();
            log.info(className+"类的"+methodName+"方法Around通知结束");
        }catch (Throwable throwable) {
            Object[] args = jp.getArgs();

            log.info("参数列表值为：");
            for (Object one: args){
                log.error(one.toString());
            }
            log.error(jp.getSignature().getDeclaringTypeName() + "类的" + jp.getSignature().getName() + "调用异常", throwable);
            Profiler.businessAlarm("spring-aop.service.Error", (new Date()).getTime(), "异常：" + className + "." + methodName + throwable.getMessage());
            Profiler.functionError(info);
        }
        finally {
            Profiler.registerInfoEnd(info);
        }

    }
}
