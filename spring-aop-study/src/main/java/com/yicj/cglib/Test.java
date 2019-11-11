package com.yicj.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
//https://www.cnblogs.com/monkey0307/p/8328821.html
public class Test {
    public static void main(String[] args) {
        //代理类class文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code\\gen");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new CglibProxyInterceptor());
        PersonService proxy= (PersonService) enhancer.create();
        proxy.setPerson();
        proxy.getPerson("1");
    }
}
