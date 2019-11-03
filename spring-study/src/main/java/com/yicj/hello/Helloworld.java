package com.yicj.hello;

import com.yicj.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Helloworld {
    public static void main(String[] args) {
        ClassPathResource res = new ClassPathResource("beans.xml") ;
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory() ;
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory) ;
        reader.loadBeanDefinitions(res) ;
        User user = factory.getBean(User.class);
        System.out.println(user);
    }
}
