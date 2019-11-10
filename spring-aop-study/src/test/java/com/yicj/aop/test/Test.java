package com.yicj.aop.test;

import com.yicj.aop.config.Appconfig;
import com.yicj.aop.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//https://blog.csdn.net/baomw/article/details/84262006
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Appconfig.class);
        annotationConfigApplicationContext.getBean(IndexDao.class).query2();
        annotationConfigApplicationContext.getBean(IndexDao.class).query();
    }
}
