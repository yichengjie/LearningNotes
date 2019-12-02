package com.yicj.s2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations= {"classpath*:/spring/**/*.xml"})
public class Bootstrap3 {
    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(Bootstrap3.class) ;
        application.run(args) ;
    }
}
