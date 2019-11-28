package com.yicj.s2.client;

import com.yicj.s2.advice.PerformanceMethodInterceptor;
import com.yicj.s2.service.ITask;
import com.yicj.s2.service.impl.MockTask;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.aopalliance.aop.Advice ;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

//根据方法名称匹配的aop测试
public class NameMatchAopTest {
    public static void main(String[] args) {
        test1() ;
        //test2() ;
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
        //这里可以不设置
        //weaver.setInterfaces(new Class[]{ITask.class});
        weaver.addAdvisor(advisor);

        //获取代理对象
        Object proxy = weaver.getProxy();
        ITask proxyObj = (ITask)proxy ;
        proxyObj.execute(null);

        //Spring Aop返回的代理对象都可以强制转型为Advised，以查询代理对象相关的信息
        Advised advised = (Advised)proxy ;
        Advisor[] advisors = advised.getAdvisors();
        for (int i = 0; i < advisors.length; i++) {
            System.out.println(advisors[i]);
        }

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
