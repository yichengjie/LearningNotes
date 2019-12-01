package com.yicj.s3.client;

import com.yicj.s3.busi.Foo2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAspectTest {
    public static void main(String[] args) {
        String path = "com/yicj/s3/client/anno1.xml" ;
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        Object proxy = context.getBean("target");
        ((Foo2)proxy).method1();
        ((Foo2)proxy).method2();
    }
}
