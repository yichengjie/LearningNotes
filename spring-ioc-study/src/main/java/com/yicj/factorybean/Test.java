package com.yicj.factorybean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Test {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("com/yicj/factorybean/beans.xml") ;
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println(beanFactory.getBean("carFactoryBean"));
        System.out.println(beanFactory.getBean("&carFactoryBean"));

    }
}
