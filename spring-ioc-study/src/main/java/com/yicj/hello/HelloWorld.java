package com.yicj.hello;

import com.yicj.hello.entity.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorld {
    public static void main(String[] args) {
        test1() ;
        //test2() ;
        //test3() ;
    }
    private static void test1(){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory() ;
        BeanFactory factory = bindViaXMLFile(beanRegistry);
        testBusi(factory) ;
    }

    private static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry) ;
        reader.loadBeanDefinitions("classpath:com/yicj/hello/beans.xml") ;
        return (BeanFactory) registry ;
    }


    private static void test2(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/yicj/s1/beans.xml") ;
        ClassPathResource resource = new ClassPathResource("com/yicj/hello/beans.xml" );
        BeanFactory factory = new XmlBeanFactory(resource) ;
        testBusi(factory) ;
    }

    private static void test3(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/yicj/hello/beans.xml") ;
        testBusi(factory) ;
    }

    private static void testBusi(BeanFactory factory){
        User user1 = (User)factory.getBean("user1");
        System.out.println("=====> " + user1);
        user1.setUsername("李四");
        //修改后再次获取的的对象值已经修改
        User user2 = (User)factory.getBean("user1");
        System.out.println("=====> " + user2);
    }
}
