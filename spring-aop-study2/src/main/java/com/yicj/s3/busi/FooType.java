package com.yicj.s3.busi;

import com.yicj.s3.annotation.AnyJoinpontAnnotation;

@AnyJoinpontAnnotation(name = "hello")
public class FooType {
    public void method1(){
        System.out.println("method1 execution.");
    }
    public void method2(){
        System.out.println("method2 execution.");
    }
}
