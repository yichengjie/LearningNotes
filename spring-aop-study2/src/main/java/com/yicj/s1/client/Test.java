package com.yicj.s1.client;

import com.yicj.s1.aspect.PersormanceMethodInterceptor;
import com.yicj.s1.service.Foo;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class Test {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory() ;
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PersormanceMethodInterceptor.class);
        Object proxy = weaver.getProxy();
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }
}
