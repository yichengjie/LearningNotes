package com.yicj.replaced2;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory() ;
        ClassPathResource resource = new ClassPathResource("com/yicj/replaced2/replace-beans.xml") ;
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory) ;
        reader.loadBeanDefinitions(resource) ;
        FXNewsProvider provider = (FXNewsProvider)beanFactory.getBean("djNewsProvider") ;
        provider.getAndPersistNews();
    }
}
