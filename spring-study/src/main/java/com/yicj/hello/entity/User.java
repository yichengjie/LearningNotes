package com.yicj.hello.entity;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

@ToString
public class User implements BeanPostProcessor {
    @Setter
    private String username ;
    @Setter
    private String addr ;
    //@Autowired
    private Pen pen ;

    public void setPen(Pen pen) {
        System.out.println("set pen called ...");
        this.pen = pen;
    }

    public User(){
        System.out.println("User constructor init ....");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
