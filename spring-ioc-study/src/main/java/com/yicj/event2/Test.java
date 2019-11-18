package com.yicj.event2;

public class Test {
    public static void main(String[] args) {
        MethodExecutionEventPublisher eventPublisher = new MethodExecutionEventPublisher() ;
        eventPublisher.addListener(new SimpleMethodExecutionEventListener());
        eventPublisher.methodToMonitor();
    }
}
