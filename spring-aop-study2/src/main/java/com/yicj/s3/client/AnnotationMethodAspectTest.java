package com.yicj.s3.client;

import com.yicj.s3.busi.FooMethod;
import com.yicj.s3.busi.FooType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMethodAspectTest {
    public static void main(String[] args) {
        String path = "com/yicj/s3/client/anno-method.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        Object proxy = context.getBean("target");
        //((FooMethod)proxy).method1();
        ((FooMethod)proxy).method2();
    }
}
