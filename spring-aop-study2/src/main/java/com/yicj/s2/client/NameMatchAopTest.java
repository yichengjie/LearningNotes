package com.yicj.s2.client;

import com.yicj.s2.advice.PerformanceMethodInterceptor;
import com.yicj.s2.service.ITask;
import com.yicj.s2.service.impl.MockTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.aopalliance.aop.Advice ;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

//根据方法名称匹配的aop测试
public class NameMatchAopTest {
    public static void main(String[] args) {
        //test1() ;
        test2() ;
    }

    public static void test1(){
        //实例化目标对象
        MockTask task = new MockTask() ;
        //实例化pointCut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut() ;
        pointcut.setMappedName("execute");
        //实例化advice
        Advice advice =  new PerformanceMethodInterceptor() ;
        //实例化advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor() ;
        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);
        //实例化织入器
        ProxyFactory weaver = new ProxyFactory(task) ;
        weaver.setInterfaces(new Class[]{ITask.class});
        weaver.addAdvisor(advisor);
        //获取代理对象
        ITask proxyObj = (ITask)weaver.getProxy() ;
        proxyObj.execute(null);
    }

    public static void test2(){
        //实例化目标对象
        MockTask task = new MockTask() ;
        //实例化advice
        Advice advice =  new PerformanceMethodInterceptor() ;
        //实例化advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor() ;
        advisor.setMappedName("execute");
        advisor.setAdvice(advice);
        //实例化织入器
        ProxyFactory weaver = new ProxyFactory(task) ;
        weaver.setInterfaces(new Class[]{ITask.class});
        weaver.addAdvisor(advisor);
        //获取代理对象
        ITask proxyObj = (ITask)weaver.getProxy() ;
        proxyObj.execute(null);
    }

}
