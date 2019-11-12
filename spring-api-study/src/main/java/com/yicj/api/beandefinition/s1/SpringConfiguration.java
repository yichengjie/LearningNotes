package com.yicj.api.beandefinition.s1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public CustomBeanDefinitionRegistry customBeanDefinitionRegistry(){
        return new CustomBeanDefinitionRegistry() ;
    }
}
