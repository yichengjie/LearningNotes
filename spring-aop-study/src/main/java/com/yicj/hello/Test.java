package com.yicj.hello;

public class Test {

    public static void main(String[] args) {
        IHelloService helloService = MyHelloProxy.getProxy(IHelloService.class);
        String hello = helloService.hello();
        System.out.println("hello world : " + hello);
    }
}
