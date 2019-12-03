package com.yicj.acturator.service.impl;

import com.yicj.acturator.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello world";
    }
}
