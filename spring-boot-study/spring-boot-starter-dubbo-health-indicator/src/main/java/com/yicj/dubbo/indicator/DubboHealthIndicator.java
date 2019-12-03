package com.yicj.dubbo.indicator;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

public class DubboHealthIndicator extends AbstractHealthIndicator {
    //针对ReferenceBean类型的bean进行健康检查
    private final ReferenceBean bean ;

    public DubboHealthIndicator(ReferenceBean bean){
        this.bean = bean ;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("interface",bean.getObjectType()) ;
        final EchoService service = (EchoService)bean.getObject() ;
        service.$echo("hi") ;
        builder.up() ;
    }
}
