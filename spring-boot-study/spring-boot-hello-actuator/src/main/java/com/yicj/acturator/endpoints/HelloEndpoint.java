package com.yicj.acturator.endpoints;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;


//自定义endpoint
@Endpoint(id = "customPoint")
@Component
public class HelloEndpoint {

    @ReadOperation
    public String getCustom(@Selector String name){
        return "MyName is ." + name ;
    }

}
