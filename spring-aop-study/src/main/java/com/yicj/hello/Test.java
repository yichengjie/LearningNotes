package com.yicj.hello;

public class Test {

    public static void main(String[] args) {
        IHelloService helloService = MyHelloProxy.getProxy(IHelloService.class);
        ITestService testService = MyHelloProxy.getProxy(ITestService.class);
        print(helloService);
        System.out.println("-------------------------------------");
        print(testService);
    }

    private static <T> void print(T service){
        Class<?> aClass = service.getClass();
        System.out.println("proxy className : " + aClass.getName());
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("interfaceName: " + anInterface.getName());
        }
    }
}
