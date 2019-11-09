package com.yicj.hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHelloProxy {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new MyHelloInvocation()
        );
    }

    static class MyHelloInvocation implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("method : " + method.getName());
            System.out.println("args : " + args);
            return "hello";
        }
    }

}
