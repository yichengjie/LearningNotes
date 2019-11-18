package com.yicj.event3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/event3/beans.xml") ;
        MethodExecutionEventPublisher publisher = (MethodExecutionEventPublisher)context.getBean("evtPublisher") ;
        publisher.methodToMonitor();
    }
}
