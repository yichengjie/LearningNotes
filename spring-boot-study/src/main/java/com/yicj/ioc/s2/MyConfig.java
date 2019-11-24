package com.yicj.ioc.s2;

import com.yicj.ioc.common.entity.Cat;
import com.yicj.ioc.common.entity.Dog;
import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean
    public Dog getDog() {
        return new Dog();
    }

    @Bean
    public Cat getCat() {
        return new Cat();
    }
}