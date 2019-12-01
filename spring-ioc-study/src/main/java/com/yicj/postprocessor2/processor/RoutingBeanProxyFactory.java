package com.yicj.postprocessor2.processor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.util.Map;

public class RoutingBeanProxyFactory {
    private final static String DEFAULT_BEAN_NAME = "helloServiceImpl1";

    public static Object createProxy(String name, Class type, Map<String, ?> candidates){
        return getObj1(name,type,candidates) ;
    }

    private static Object getObj1(String name, Class type, Map<String, ?> candidates){
        ProxyFactory proxyFactory = new ProxyFactory() ;
        proxyFactory.setInterfaces(type);
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(name,candidates));
        return proxyFactory.getProxy() ;
    }

    private static Object getObj2(String name, Class type, Map<String, ?> candidates){
        Object obj = candidates.get(name);
        if(obj == null){
            obj = candidates.get(DEFAULT_BEAN_NAME) ;
        }
        return obj ;
    }


    static class VersionRoutingMethodInterceptor implements MethodInterceptor {
        private Object targetObject;

        public VersionRoutingMethodInterceptor(String name, Map<String, ?> beans){
            this.targetObject = beans.get(name) ;
            if(this.targetObject == null){
                this.targetObject = beans.get(DEFAULT_BEAN_NAME) ;
            }
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return invocation.getMethod()
                    .invoke(this.targetObject,invocation.getArguments());
        }
    }
}
