package com.yicj.s1;

import com.yicj.s1.advice.PersormanceMethodInterceptor;
import com.yicj.s1.advice.TesterFeatureIntroductionInterceptor;
import com.yicj.s1.service.IDeveloper;
import com.yicj.s1.service.ITester;
import com.yicj.s1.service.impl.Developer;
import com.yicj.s1.service.impl.Executable;
import com.yicj.s1.service.ITask;
import com.yicj.s1.service.impl.MockTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

@Slf4j
public class Test {

    public static void main(String[] args) {
        //基于接口的代码
        //testInterfaceProxy() ;
        //testExtendsProxy() ;
        testIntroductionProxy() ;
    }

    //基于接口的代理
    public static void testInterfaceProxy(){
        MockTask task = new MockTask() ;
        ProxyFactory weaver = new ProxyFactory(task) ;
        //设置接口
        //这里如果不设置接口也会自动使用基于接口的代理
        weaver.setInterfaces(new Class[]{ITask.class});
        //weaver.setProxyTargetClass(true);
        //组装advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor() ;
        advisor.setMappedName("execute");
        advisor.setAdvice(new PersormanceMethodInterceptor());
        //将advisor设置到织入器中
        weaver.addAdvisor(advisor);
        //获取代理对象
        ITask proxyObject = (ITask)weaver.getProxy() ;
        proxyObject.execute(null);
    }

    public static void testExtendsProxy(){
        ProxyFactory weaver = new ProxyFactory(new Executable()) ;
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor() ;
        advisor.setMappedName("execute");
        advisor.setAdvice(new PersormanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        Executable proxyObject = (Executable) weaver.getProxy() ;
        proxyObject.execute();
        log.info(proxyObject.getClass().getName());
    }

    public static void testIntroductionProxy(){
        ProxyFactory weaver = new ProxyFactory(new Developer()) ;
        weaver.setInterfaces(new Class[]{IDeveloper.class, ITester.class});
        TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor() ;
        weaver.addAdvice(advice);
        Object proxy = weaver.getProxy();
        ((ITester)proxy).testSoftware();
        ((IDeveloper)proxy).developSoftware();
    }
}
