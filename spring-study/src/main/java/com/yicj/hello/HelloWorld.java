package com.yicj.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        test2() ;
    }
    private static void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
        Object user1 = context.getBean("user2");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        Object user2 = context.getBean("user2");
        System.out.println("user1 : " + user1);
        System.out.println("user2 : " + user2);
        System.out.println(user1 == user2);
    }
//    private static void test1(){
//        ClassPathResource res = new ClassPathResource("beans.xml") ;
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory() ;
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory) ;
//        reader.loadBeanDefinitions(res) ;
//        User user = factory.getBean(User.class);
//        System.out.println(user);
//    }
}
