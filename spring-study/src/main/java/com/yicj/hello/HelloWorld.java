package com.yicj.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        test2() ;
    }
    private static void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/yicj/hello/beans.xml") ;
        Object user1 = context.getBean("user1");
        System.out.println(user1);
    }
}
