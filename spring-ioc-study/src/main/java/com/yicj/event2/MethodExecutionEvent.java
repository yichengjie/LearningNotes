package com.yicj.event2;

import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

public class MethodExecutionEvent extends EventObject {
    @Getter
    @Setter
    private String methodName ;

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source,String methodName){
        super(source);
        this.methodName = methodName ;
    }
}
