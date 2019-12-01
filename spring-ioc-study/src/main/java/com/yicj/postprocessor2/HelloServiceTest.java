package com.yicj.postprocessor2;

import com.yicj.postprocessor2.annotation.RoutingInjected;
import com.yicj.postprocessor2.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceTest {

    @RoutingInjected(value = "helloServiceImpl2")
    private HelloService helloService ;

    public void testSayHello(){
        helloService.sayHello();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.yicj.postprocessor2") ;
        HelloServiceTest helloServiceTest = context.getBean(HelloServiceTest.class) ;
        helloServiceTest.testSayHello();
    }
}
