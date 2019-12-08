package com.lucene.test.config.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhang_htao on 2019/12/4.
 */
@Component
@Aspect
public class ControllerIncommingParamLog {

    private static final Logger logger = LoggerFactory.getLogger(ControllerIncommingParamLog.class);

    @Pointcut(value = "@annotation(com.lucene.test.config.log.annotations.ParamLog)")
    private void customPointCut(){
    }

    @Before(value = "customPointCut()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        int length = args.length;

        logger.debug("请求的方法名为：{}",name);
        logger.debug("请求的入参的个数为：{}",length);
        logger.debug("请求的入参为：{}",args);
    }

    @AfterReturning(value = "customPointCut()",returning = "obj")
    public void afterReturn(JoinPoint joinPoint,Object obj) {

        logger.debug("请求的方法名为：{}",joinPoint.getSignature().getName());
        logger.debug("请求的结果为：{}",obj);
    }
}
