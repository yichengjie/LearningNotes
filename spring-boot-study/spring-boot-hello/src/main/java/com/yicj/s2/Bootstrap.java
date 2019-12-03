package com.yicj.s2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {

    public static void main(String[] args) throws IOException {
        String path = "services.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        ((AbstractApplicationContext)context).registerShutdownHook();
        System.in.read() ;
    }

}
