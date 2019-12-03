package com.yicj.metrics.controller;

import com.yicj.metrics.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private HelloService helloService ;

    @GetMapping("/")
    public String index(){
        helloService.hello();
        helloService.hello();
        helloService.hello();
        helloService.hello();
        helloService.hello();
        return "hello" ;
    }
}
