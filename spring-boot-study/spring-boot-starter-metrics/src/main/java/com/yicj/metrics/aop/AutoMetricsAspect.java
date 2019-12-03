package com.yicj.metrics.aop;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.concurrent.ConcurrentHashMap;
import static com.codahale.metrics.MetricRegistry.name;

@Component
@Aspect
public class AutoMetricsAspect {
    protected ConcurrentHashMap<String, Meter> meters = new ConcurrentHashMap<>() ;
    protected ConcurrentHashMap<String, Meter> exceptionMeters = new ConcurrentHashMap<>() ;
    protected ConcurrentHashMap<String, Timer> timers = new ConcurrentHashMap<>() ;
    protected ConcurrentHashMap<String, Counter> counters = new ConcurrentHashMap<>() ;
    @Autowired
    private MetricRegistry metricRegistry ;

    @Pointcut("execution(public * *(..))")
    public void publicMethod(){}

    @Before("publicMethod() && @annotation(countedAnno)")
    public void instrumentCounted(JoinPoint jp , Counted countedAnno){
        String temp = StringUtils.hasLength(countedAnno.name())
                ? countedAnno.name()
                : jp.getSignature().getName() ;
        String name = name(jp.getTarget().getClass(),temp,"counter" ) ;
        Counter counter = counters.computeIfAbsent(name,key -> metricRegistry.counter(key)) ;
        counter.inc();
    }


    @Before("publicMethod() && @annotation(meteredAnno)")
    public void instrumentMetered(JoinPoint jp , Metered meteredAnno){
        String temp = StringUtils.hasLength(meteredAnno.name())
                ? meteredAnno.name()
                : jp.getSignature().getName() ;
        String name = name(jp.getTarget().getClass(),temp,"meter") ;
        Meter meter = meters.computeIfAbsent(name,key -> metricRegistry.meter(key)) ;
        meter.mark();
    }

    @AfterThrowing(value = "publicMethod() && @annotation(exMeteredAnno)",throwing = "ex")
    public void instrumentExceptionMetered(
            JoinPoint jp , Throwable ex, ExceptionMetered exMeteredAnno){
        String temp = StringUtils.hasLength(exMeteredAnno.name())
                ? exMeteredAnno.name()
                : jp.getSignature().getName() ;
        String name = name(jp.getTarget().getClass(),temp,"meter","exception") ;
        Meter meter = exceptionMeters.computeIfAbsent(name,meterName -> metricRegistry.meter(meterName)) ;
        meter.mark();
    }

    @Around("publicMethod() && @annotation(timedAnno)")
    public Object instrumentTimed(ProceedingJoinPoint pjp, Timed timedAnno) throws Throwable{
        String temp = StringUtils.hasLength(timedAnno.name())
                ? timedAnno.name()
                : pjp.getSignature().getName() ;
        String name = name(pjp.getTarget().getClass(),"timer") ;
        Timer timer = timers.computeIfAbsent(name,inputName -> metricRegistry.timer(inputName)) ;
        Timer.Context tc = timer.time() ;
        try {
            return pjp.proceed() ;
        }finally {
            tc.stop() ;
        }

    }

}
