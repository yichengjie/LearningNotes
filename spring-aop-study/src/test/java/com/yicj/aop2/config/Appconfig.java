package com.yicj.aop2.config;

import com.yicj.aop2.annotation.EnableAop;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yicj.aop")
@EnableAop
public class Appconfig {
}
