package com.yicj.dubbo.runner;

import com.yicj.dubbo.ext.ShutdownLatch;
import org.springframework.boot.CommandLineRunner;

public class DubboServiceLatchCommandLineRunner implements CommandLineRunner {
    private String domain = "com.yicj.services.management" ;
    @Override
    public void run(String... args) throws Exception {
        ShutdownLatch latch = new ShutdownLatch(domain) ;
        latch.await();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
