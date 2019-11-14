package com.yicj.interf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/interf/beans.xml") ;
        FXNewProvider provider = context.getBean(FXNewProvider.class);
        provider.getAndPersistNews();
    }
}
