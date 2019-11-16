package com.yicj.hello;

import com.yicj.hello.entity.User;
import com.yicj.hello.service.IFXNewsListener;
import com.yicj.hello.service.impl.DowJonesNewsListener;
import com.yicj.hello.service.impl.DowJonesNewsPersister;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorld {
    public static void main(String[] args) {
        test1() ;
        //test2() ;
        //test3() ;
        //test4() ;
        //test5() ;
    }
    private static void test1(){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory() ;
        BeanFactory factory = bindViaCodeByConstructor(beanRegistry);
        FXNewsProvider djProvider = (FXNewsProvider)factory.getBean("djProvider");
        djProvider.getAndPersistNews();
    }

    private static void test2(){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory() ;
        BeanFactory factory = bindViaCodeBySetter(beanRegistry);
        FXNewsProvider djProvider = (FXNewsProvider)factory.getBean("djProvider");
        djProvider.getAndPersistNews();
    }

    private static void test3(){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory() ;
        BeanFactory factory = bindViaXMLFile(beanRegistry);
        testBusi(factory) ;
    }

    private static void test4(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/yicj/s1/beans.xml") ;
        ClassPathResource resource = new ClassPathResource("com/yicj/hello/beans.xml" );
        BeanFactory factory = new XmlBeanFactory(resource) ;
        testBusi(factory) ;
    }

    private static void test5(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/yicj/hello/beans.xml") ;
        testBusi(factory) ;
    }

    private static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry) ;
        reader.loadBeanDefinitions("classpath:com/yicj/hello/beans.xml") ;
        return (BeanFactory) registry ;
    }

    private static BeanFactory bindViaCodeByConstructor(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider =
                new RootBeanDefinition(FXNewsProvider.class) ;
        AbstractBeanDefinition newsListener =
                new RootBeanDefinition(DowJonesNewsListener.class) ;
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class) ;
        //将bean定义注册到容器中
        registry.registerBeanDefinition("djProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersister",newsPersister);
        //指定依赖关系
        //通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues() ;
        argValues.addIndexedArgumentValue(0,newsListener);
        argValues.addIndexedArgumentValue(1,newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);
        //绑定完成
        return (BeanFactory) registry ;
    }

    private static BeanFactory bindViaCodeBySetter(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider =
                new RootBeanDefinition(FXNewsProvider.class) ;
        AbstractBeanDefinition newsListener =
                new RootBeanDefinition(DowJonesNewsListener.class) ;
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class) ;
        //将bean定义注册到容器中
        registry.registerBeanDefinition("djProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersister",newsPersister);
        //指定依赖关系
        //通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues() ;
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener)) ;
        propertyValues.addPropertyValue(new PropertyValue("newsPersister",newsPersister)) ;
        newsProvider.setPropertyValues(propertyValues);
        //绑定完成
        return (BeanFactory) registry ;
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
