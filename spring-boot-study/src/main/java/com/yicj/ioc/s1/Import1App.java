package com.yicj.ioc.s1;

import com.yicj.ioc.common.entity.Cat;
import com.yicj.ioc.common.entity.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan
//把用到的资源导入到当期容器中
@Import({Dog.class, Cat.class})
public class Import1App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Import1App.class,args) ;
        System.out.println(context.getBean(Dog.class));
        System.out.println(context.getBean(Cat.class));
    }
}
