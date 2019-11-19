package com.yicj.s1.advice;

import com.yicj.s1.service.ITester;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

@Slf4j
public class TesterFeatureIntroductionInterceptor extends DelegatingIntroductionInterceptor implements ITester {
    private boolean busyAsTester ;

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if(isBusyAsTester() && mi.getMethod().getName().equals("developSoftware")){
            throw new RuntimeException("你想累死我呀?") ;
        }
        return super.invoke(mi);
    }

    @Override
    public void testSoftware() {
        log.info("I will ensure the quality .");
    }

    @Override
    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }
}
