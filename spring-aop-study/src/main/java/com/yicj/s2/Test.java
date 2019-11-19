package com.yicj.s2;

import com.yicj.s2.service.ITask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/s2/beans.xml") ;
        ITask task = (ITask)context.getBean("taskProxy") ;
        task.execute(null);
    }
}
