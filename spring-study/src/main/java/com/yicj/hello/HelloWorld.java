package com.yicj.hello;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorld {
    public static void main(String[] args) {
        test1() ;
        //test2() ;
    }
    private static void test2(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/yicj/hello/beans.xml") ;
        ClassPathResource resource = new ClassPathResource("com/yicj/hello/beans.xml" );
        XmlBeanFactory factory = new XmlBeanFactory(resource) ;
        System.out.println("--------------------------------------");
        Object user1 = factory.getBean("user1");
        //System.out.println(user1);
    }

    private static void test1(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/yicj/hello/beans.xml") ;
        System.out.println("--------------------------------------");
        Object user1 = factory.getBean("user1");
        System.out.println(user1);
    }
}
