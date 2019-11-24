package com.yicj.api.import1.s1;

import com.yicj.api.import1.s2.Config2;
import com.yicj.api.import1.service.UserService;
import com.yicj.api.import1.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config1.class) ;
        UserService userService =
                context.getBean(UserServiceImpl.class) ;
        userService.save(null) ;
        context.close();
    }

}
