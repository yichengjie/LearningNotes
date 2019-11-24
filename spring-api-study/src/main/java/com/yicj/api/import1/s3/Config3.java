package com.yicj.api.import1.s3;

import org.springframework.context.annotation.Configuration;

//通过ImportSelector方式注入Bean
//上面通过ImportBeanDefinitionRegistrar的方式注入的实例需要我们操作
// BeanDefinitionRegistry 对象，而通过ImportSelector方式我们可以
// 不操作BeanDefinitionRegistry 对象，只需要告诉容器我们需要注入类
// 的完整类名就好
@Configuration
@EnableUserService(name = "ivan_test")
public class Config3 {

}
