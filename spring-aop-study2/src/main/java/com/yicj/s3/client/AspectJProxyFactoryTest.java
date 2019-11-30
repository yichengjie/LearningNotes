package com.yicj.s3.client;

import com.yicj.s3.aspect.PerformanceTraceAspect;
import com.yicj.s3.busi.Foo;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyFactoryTest {
    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory() ;
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }
}
