package com.yicj.postprocessor2.service.impl;

import com.yicj.postprocessor2.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl1 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }
}
