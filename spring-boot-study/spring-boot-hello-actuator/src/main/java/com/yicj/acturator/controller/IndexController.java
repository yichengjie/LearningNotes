package com.yicj.acturator.controller;

import com.yicj.acturator.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private HelloService helloService ;

    @GetMapping("/")
    public String index(){
        return helloService.hello() ;
    }
}
