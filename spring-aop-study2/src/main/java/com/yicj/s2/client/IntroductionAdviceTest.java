package com.yicj.s2.client;

import com.yicj.s2.service.ITester;
import com.yicj.s2.service.impl.Developer;
import com.yicj.s2.service.impl.TesterFeatureIntroductionInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IntroductionAdviceTest {

    public static void main(String[] args) {
        //test1() ;
        test2() ;
    }
    public static void test1(){
        ProxyFactory weaver = new ProxyFactory(new Developer()) ;
        weaver.setProxyTargetClass(true);
        weaver.setInterfaces(new Class[]{ITester.class});
        TesterFeatureIntroductionInterceptor advice =
                new TesterFeatureIntroductionInterceptor() ;
        //weaver.addAdvice(advice);
        DefaultIntroductionAdvisor advisor =
                new DefaultIntroductionAdvisor(advice,advice) ;
        weaver.addAdvisor(advisor);
        Object proxy = weaver.getProxy() ;
        ((ITester)proxy).testSoftware();
        ((Developer)proxy).developSoftware();
    }

    public static void test2(){
        ProxyFactory weaver = new ProxyFactory(new Developer()) ;
        weaver.setProxyTargetClass(true);
        weaver.setInterfaces(new Class[]{ITester.class});
        TesterFeatureIntroductionInterceptor advice =
                new TesterFeatureIntroductionInterceptor() ;
        weaver.addAdvice(advice);
        //DefaultIntroductionAdvisor advisor =
        //  new DefaultIntroductionAdvisor(advice,advice) ;
        //weaver.addAdvisor(advisor);
        Object proxy = weaver.getProxy() ;
        ((ITester)proxy).testSoftware();
        ((Developer)proxy).developSoftware();
    }
}
