package com.yicj.event3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.EventObject;

public class MethodExecutionEvent extends ApplicationEvent {
    @Getter
    private String methodName ;
    @Getter
    private MethodExecutionStatus status ;

    public MethodExecutionEvent(Object source) {
        super(source);
    }
    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName ;
    }

    public MethodExecutionEvent(Object source, String methodName,MethodExecutionStatus status) {
        super(source);
        this.methodName = methodName ;
        this.status = status ;
    }
}
