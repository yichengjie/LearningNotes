package com.yicj.s3.client;

import com.yicj.s3.busi.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyCreatorTest {
    public static void main(String[] args) {
        String path = "com/yicj/s3/client/auto-proxy-creator.xml" ;
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        Object proxy = context.getBean("target");
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }
}
