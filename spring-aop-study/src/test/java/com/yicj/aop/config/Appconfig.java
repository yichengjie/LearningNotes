package com.yicj.aop.config;

import com.yicj.aop.annotation.EnableAop;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yicj.aop")
@EnableAop
public class Appconfig {
}
