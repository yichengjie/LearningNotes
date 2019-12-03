package com.yicj.dubbo.controller;

import com.yicj.dubbo.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    @Autowired
    private CurrencyRateService rateService ;

    @GetMapping("/")
    public String index(){
        log.info("rateService ========> " + rateService);
        return "hello" ;
    }
}
