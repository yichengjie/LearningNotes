package com.yicj.s1.client2;

import com.yicj.s1.service.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/s1/client2/beans.xml") ;
        Object proxy = context.getBean("foo");
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }
}
