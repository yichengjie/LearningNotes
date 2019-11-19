package com.yicj.s3.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

@Slf4j
public class PersormanceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch() ;
        try {
            watch.start();
            return invocation.proceed() ;
        }finally {
            watch.stop();
            log.info("===================> {}" , watch.toString());
        }
    }
}
