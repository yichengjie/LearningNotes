package com.yicj.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof TestEvent){
            TestEvent testEvent = TestEvent.class.cast(event) ;
            testEvent.print();
        }
    }
}
