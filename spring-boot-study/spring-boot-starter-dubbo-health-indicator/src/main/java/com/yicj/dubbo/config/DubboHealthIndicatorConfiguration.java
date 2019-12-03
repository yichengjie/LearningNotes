package com.yicj.dubbo.config;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.yicj.dubbo.indicator.DubboHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnClass(name = {"com.alibaba.dubbo.rpc.Exporter"})
public class DubboHealthIndicatorConfiguration {
    @Autowired
    private HealthAggregator healthAggregator ;

    //获取ioc容器中的指定类型的bean,
    // 针对当前应用引用的所有dubbo服务进行健康检查
    @Autowired
    private Map<String, ReferenceBean> references ;

    @Bean
    public HealthIndicator dubboHealthIndicator(){
        Map<String,HealthIndicator> indicators = new HashMap<>() ;
        for(String key : references.keySet()){
            final ReferenceBean bean = references.get(key) ;
            String tmp = key.startsWith("&") ? key.replaceFirst("&","") : key ;
            indicators.put(tmp,new DubboHealthIndicator(bean)) ;
        }
        return new CompositeHealthIndicator(healthAggregator,indicators) ;
    }
}
