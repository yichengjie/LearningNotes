package com.yicj.s1.advice;

import com.yicj.s1.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

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
            log.info(watch.toString());
        }
    }
}
