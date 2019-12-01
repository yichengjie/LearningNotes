
package com.yicj.s3.aspect;

import com.yicj.s3.annotation.AnyJoinpontAnnotation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationTypeAspect {

    @Pointcut("execution(* com.yicj.s3..*.method1()) && @within(anno)")
    public void mypointcut(AnyJoinpontAnnotation anno){}

    @Before("mypointcut(anno)")
    public void before(AnyJoinpontAnnotation anno){
        String name = anno.name() ;
        System.out.println("name : " + name);
    }
}
