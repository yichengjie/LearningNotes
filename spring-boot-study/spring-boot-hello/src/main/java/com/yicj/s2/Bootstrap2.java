package com.yicj.s2;

import com.yicj.s2.ext.ShutdownLatch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap2 {
    public static void main(String[] args) throws Exception {
        String path = "services.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
        ((AbstractApplicationContext)context).registerShutdownHook();
        ShutdownLatch latch = new ShutdownLatch("your_domain_for_mbeans") ;
        latch.await();
    }
}
