package com.yicj.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations= {"classpath*:/spring/**/*.xml"})
public class Bootstrap  {
    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(Bootstrap.class) ;
        application.run(args) ;
    }
}
