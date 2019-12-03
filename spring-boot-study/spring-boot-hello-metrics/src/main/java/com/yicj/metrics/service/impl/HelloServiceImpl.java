package com.yicj.metrics.service.impl;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Timed;
import com.yicj.metrics.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Counted
    @Timed
    @Override
    public void hello() {
        System.out.println("just do something");
    }
}
