package com.yicj.s3.busi;

import com.yicj.s3.annotation.AnyJoinpontAnnotation;

@AnyJoinpontAnnotation(name = "hello")
public class FooMethod {
    @AnyJoinpontAnnotation(name = "add")
    public void method1(){
        System.out.println("method1 execution.");
    }
    @AnyJoinpontAnnotation(name = "delete")
    public void method2(){
        System.out.println("method2 execution.");
        int a = 1/0 ;
    }
}
