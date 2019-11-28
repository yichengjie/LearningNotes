package com.yicj.s2.client;

import com.yicj.s2.service.ITask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        String path = "com/yicj/s2/client/proxy-factorybean.xml" ;
        ApplicationContext context =
                new ClassPathXmlApplicationContext(path) ;
        ITask task = (ITask)context.getBean("taskProxy") ;
        task.execute(null);
    }
}
