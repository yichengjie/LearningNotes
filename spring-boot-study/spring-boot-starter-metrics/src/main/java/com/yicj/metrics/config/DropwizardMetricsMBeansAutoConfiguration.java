package com.yicj.metrics.config;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.management.MBeanServer;

@Configuration
@ComponentScan({"com.yicj.metrics.aop","com.yicj.metrics.lifecycle"})
@AutoConfigureAfter(AopAutoConfiguration.class)
public class DropwizardMetricsMBeansAutoConfiguration {
    @Value("${metrics.mbeans.domain.name:com.yicj.metrics}")
    private String metricsMBeanDomainName;
    @Autowired
    private MBeanServer mBeanServer ;
    @Autowired
    private MetricRegistry metricRegistry ;

    public JmxReporter jmxReporter(){
        JmxReporter reporter = JmxReporter
                .forRegistry(metricRegistry)
                .inDomain(metricsMBeanDomainName)
                .registerWith(mBeanServer)
                .build() ;
        return reporter ;
    }


}
