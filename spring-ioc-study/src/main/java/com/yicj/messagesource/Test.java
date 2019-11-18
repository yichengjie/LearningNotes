package com.yicj.messagesource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Locale;


public class Test {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/yicj/messagesource/beans.xml") ;
        String fileMenuName = context.getMessage("menu.file", new Object[]{"F"}, Locale.US);
        String eidtMenuName = context.getMessage("menu.edit",null,Locale.US) ;
        System.out.println("fileMenuName : " + fileMenuName);
        System.out.println("eidtMenuName : " + eidtMenuName);
    }
}
