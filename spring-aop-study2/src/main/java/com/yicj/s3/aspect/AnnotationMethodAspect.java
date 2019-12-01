
package com.yicj.s3.aspect;

import com.yicj.s3.annotation.AnyJoinpontAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotationMethodAspect {

    @Pointcut("@annotation(com.yicj.s3.annotation.AnyJoinpontAnnotation) && " +
              "@annotation(anno)")
    public void mypointcut(AnyJoinpontAnnotation anno){}

    @Pointcut("( execution(public void com.yicj..*.method1()) || " +
                "execution(public void com.yicj..*.method2()) )&& " +
                "@annotation(anno)")
    public void mypointcut2(AnyJoinpontAnnotation anno){}

    @Before("mypointcut(anno)")
    public void before(AnyJoinpontAnnotation anno){
        System.out.println("before method do something .");
        System.out.println("anno name is : " + anno.name());
    }

    @After("mypointcut2(anno)")
    public void after(JoinPoint joinPoint, AnyJoinpontAnnotation anno){
        String name = joinPoint.getSignature().getName() ;
        System.out.println("=====> signature : " + name);
        System.out.println("after method do something .");
        System.out.println("anno name is : " + anno.name());
    }

    @AfterThrowing(value = "execution(void com.yicj..*.*(..))",throwing = "e")
    public void afterThrowing(RuntimeException e){
        String message = e.getMessage();
        System.out.println("全局异常捕获： " + message + " , " + e.toString());
    }

}
