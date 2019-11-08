package com.yicj.replaced;

import com.yicj.replaced.busi.OriginalDog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/yicj/replaced/beans.xml")  ;
        OriginalDog originalDog =
            context.getBean("originalDogReplaceMethod",OriginalDog.class) ;
        originalDog.sayHello();
        System.out.println("======================================");
        originalDog.sayHello("小黄");
    }
}
