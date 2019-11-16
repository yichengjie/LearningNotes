package com.yicj.lookup2;

import com.yicj.lookup2.service.impl.MockNewsPersister;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MethodInjectTest {
    public static void main(String[] args) {
        BeanFactory container = new XmlBeanFactory(
            new ClassPathResource("com/yicj/lookup2/beans-lookup.xml")) ;
        MockNewsPersister mockPersister =
                (MockNewsPersister)container.getBean("mockPersister") ;
        mockPersister.persistNews();
        System.out.println("-------------> " + mockPersister.newsBean);
        mockPersister.persistNews();
        System.out.println("-------------> " + mockPersister.newsBean);
    }
}
