
package com.yicj.s3.aspect;

import com.yicj.s3.annotation.AnyJoinpontAnnotation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationMethodAspect {

    @Pointcut("@annotation(com.yicj.s3.annotation.AnyJoinpontAnnotation) && @annotation(anno)")
    public void mypointcut(AnyJoinpontAnnotation anno){}

    @Before("mypointcut(anno)")
    public void before(AnyJoinpontAnnotation anno){
        System.out.println("before method do something .");
        System.out.println("anno name is : " + anno.name());
    }

}
