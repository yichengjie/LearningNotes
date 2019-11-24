package com.yicj.api.import1.s2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(value="ivan_test")
@Import({UserServiceBeanDefinitionRegistrar.class})
public class Config2 {
}
