package com.yicj.s3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
public class PerformanceTraceAspect {
    @Pointcut("execution(public void *.method1()) || " +
              "execution(public void *.method2())")
    public void pointcutName() {}

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint)throws Throwable {
        StopWatch watch = new StopWatch() ;
        try {
            watch.start();
            return joinPoint.proceed() ;
        }finally {
            watch.stop();
            log.info("PT in method[" +
                    joinPoint.getSignature().getName() +"]>>>> "
                    + watch.toString());
        }
    }
}
