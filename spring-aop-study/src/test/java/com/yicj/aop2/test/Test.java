package com.yicj.aop2.test;

import com.yicj.aop2.config.Appconfig;
import com.yicj.aop2.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//https://blog.csdn.net/baomw/article/details/84262006
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  =
                new AnnotationConfigApplicationContext(Appconfig.class);
        System.out.println("===================================");
        context.getBean(IndexDao.class).query2();
        System.out.println("===================================");
        context.getBean(IndexDao.class).query();
    }
}
