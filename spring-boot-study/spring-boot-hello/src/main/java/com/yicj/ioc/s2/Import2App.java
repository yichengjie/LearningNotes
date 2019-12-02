package com.yicj.ioc.s2;

import com.yicj.ioc.common.entity.Cat;
import com.yicj.ioc.common.entity.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan
//导入配置类即可
@Import(MyConfig.class)
public class Import2App {
    public static void main(String[] args) {
        ConfigurableApplicationContext contex =
                SpringApplication.run(Import2App.class, args);
        System.out.println(contex.getBean(Dog.class));
        System.out.println(contex.getBean(Cat.class));
    }
}
