package com.yicj.replaced2;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

@Slf4j
public class FXNewsProviderMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method,
                              Object[] args) throws Throwable {
        log.info("before executing method ["+method.getName()+
                "] on Object ["+obj.getClass().getName()+"].");
        log.info("sorry . We will do nothing this time.");
        log.info("end of executing method ["+method.getName()+
                "] on Object ["+obj.getClass().getName()+"]");
        return null;
    }
}
