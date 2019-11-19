package com.yicj.s3;

import com.yicj.s3.service.ICounter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        String path = "com/yicj/s3/beans.xml" ;
        String path2 = "com/yicj/s3/beans2.xml" ;
        ApplicationContext context =
                new ClassPathXmlApplicationContext(path2) ;
        Object proxy1 = context.getBean("introducedTask") ;
        Object proxy2 = context.getBean("introducedTask") ;
        System.out.println(((ICounter)proxy1).getCounter());
        System.out.println(((ICounter)proxy1).getCounter());
        System.out.println(((ICounter)proxy2).getCounter());
    }
}
