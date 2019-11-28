package com.yicj.s2.service.impl;

import com.yicj.s2.service.ITester;
import lombok.Setter;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class TesterFeatureIntroductionInterceptor extends
        DelegatingIntroductionInterceptor implements ITester {

    @Setter
    private boolean busyAsTester ;

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if(isBusyTester() &&
                mi.getMethod().getName().contains("developSoftware")){
            throw new RuntimeException("你想累死我呀?") ;
        }
        return super.invoke(mi);
    }

    @Override
    public boolean isBusyTester() {
        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("I will ensure the quality.");
    }
}
