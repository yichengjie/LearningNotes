package com.yicj.s1;

import com.yicj.s1.advice.PersormanceMethodInterceptor;
import com.yicj.s1.service.ITask;
import com.yicj.s1.service.impl.MockTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class Test {

    public static void main(String[] args) {
        //基于接口的代码
        testInterfaceProxy() ;

    }

    //基于接口的代理
    public static void testInterfaceProxy(){
        MockTask task = new MockTask() ;
        ProxyFactory weaver = new ProxyFactory(task) ;
        //设置接口
        weaver.setInterfaces(new Class[]{ITask.class});
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
}
