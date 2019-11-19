package com.yicj.s2;

import com.yicj.s2.service.ITask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        String path = "com/yicj/s2/beans.xml" ;
        //String path = "com/yicj/s2/beans2.xml" ;
        //String path = "com/yicj/s2/beans3.xml" ;
        ApplicationContext context =
                new ClassPathXmlApplicationContext("") ;
        ITask task = (ITask)context.getBean("taskProxy") ;
        task.execute(null);
        System.out.println(task.getClass().getName());
    }
}
