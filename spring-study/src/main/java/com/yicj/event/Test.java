package com.yicj.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/event/beans.xml" ) ;
        TestEvent event = new TestEvent("hello","msg") ;
        context.publishEvent(event);
    }
}
