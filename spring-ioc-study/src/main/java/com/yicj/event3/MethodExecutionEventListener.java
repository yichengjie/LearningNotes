package com.yicj.event3;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MethodExecutionEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof MethodExecutionEvent){
            //执行处理逻辑
            MethodExecutionEvent event = (MethodExecutionEvent) applicationEvent ;
            System.out.println("method name : "  + event.getMethodName());
        }
    }
}
