package com.yicj.lookup2;

import com.yicj.lookup2.serviceimpl.MockNewsPersister;
import com.yicj.lookup2.serviceimpl.MockNewsPersister2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MethodInjectTest {
    public static void main(String[] args) {
        //test1() ;
        test2() ;
    }

    public static void test1(){
        BeanFactory container = new XmlBeanFactory(
                new ClassPathResource("com/yicj/lookup2/beans-lookup.xml")) ;
        MockNewsPersister mockPersister =
                (MockNewsPersister)container.getBean("mockPersister") ;
        mockPersister.persistNews();
        System.out.println("-------------> " + mockPersister.newsBean);
        mockPersister.persistNews();
        System.out.println("-------------> " + mockPersister.newsBean);
    }

    public static void test2(){
        BeanFactory container = new XmlBeanFactory(
                new ClassPathResource("com/yicj/lookup2/beans-lookup.xml")) ;
        MockNewsPersister2 mockPersister2 =
                (MockNewsPersister2)container.getBean("mockPersister2") ;
        mockPersister2.persistNews();
        mockPersister2.persistNews();
    }
}
