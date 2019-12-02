package com.yicj.dubbo.config;

import com.yicj.dubbo.runner.DubboServiceLatchCommandLineRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order
@Slf4j
public class DubboAutoConfiguration {

    @Value("${shutdown.latch.domain.name: com.yicj.services.management}")
    private String shutdownLatchDomainName ;

    @Bean
    public DubboServiceLatchCommandLineRunner configureDubboServiceLatchCommandLineRunner(){
        log.debug("DubboAutoConfiguration enable by adding DubboServiceLatchCommandLineRunner ...");
        DubboServiceLatchCommandLineRunner runner = new DubboServiceLatchCommandLineRunner() ;
        runner.setDomain(shutdownLatchDomainName);
        return runner ;
    }
}
