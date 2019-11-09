package com.yicj.date;

import com.yicj.date.entity.UserManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/date/beans.xml");
        UserManager userManager = context.getBean(UserManager.class);
        System.out.println(userManager);
    }
}
