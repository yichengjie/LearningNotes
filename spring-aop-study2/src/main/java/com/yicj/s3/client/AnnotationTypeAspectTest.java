package com.yicj.s3.client;

import com.yicj.s3.busi.FooType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTypeAspectTest {
    public static void main(String[] args) {
        String path = "com/yicj/s3/client/anno-type.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        Object proxy = context.getBean("target");
        ((FooType)proxy).method1();
        ((FooType)proxy).method2();
    }
}
