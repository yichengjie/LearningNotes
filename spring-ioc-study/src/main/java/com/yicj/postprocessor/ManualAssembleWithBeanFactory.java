package com.yicj.postprocessor;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

//手动装配BeanFactory使用BeanFactoryPostProcessor
public class ManualAssembleWithBeanFactory {
    public static void main(String[] args) {
        //申明将被后处理的BeanFactory实例
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("...")) ;
        //申明要使用的BeanFactoryPostProcessor
        PropertyPlaceholderConfigurer propertyPostProcessor = new PropertyPlaceholderConfigurer() ;
        propertyPostProcessor.setLocation(new ClassPathResource("..."));
        //执行后处理操作
        propertyPostProcessor.postProcessBeanFactory(beanFactory);

    }
}
