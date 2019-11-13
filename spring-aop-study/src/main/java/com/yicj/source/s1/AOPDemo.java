package com.yicj.source.s1;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.SingletonTargetSource;

public class AOPDemo {
    public static void main(String[] args) {
        TargetBean target = new TargetBean() ;
        TargetSource targetSource = new SingletonTargetSource(target) ;
        //使用SpringAop框架的代理工厂直接创建代理对象
        TargetBean proxy = (TargetBean) ProxyFactory.getProxy(targetSource) ;
        System.out.println(proxy.getClass().getName());
    }
}
