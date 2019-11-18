package com.yicj.event2;

import java.util.ArrayList;
import java.util.List;

public class MethodExecutionEventPublisher {
    private List<MethodExecutionEventListener> listeners = new ArrayList<>() ;
    public void methodToMonitor(){
        MethodExecutionEvent event2Publish =
                new MethodExecutionEvent(this,"methodToMonitor") ;
        publishEvent(MethodExecutionStatus.BEGIN,event2Publish) ;
    }

    protected void publishEvent(MethodExecutionStatus status,MethodExecutionEvent methodExecutionEvent){
        List<MethodExecutionEventListener> copyListeners = new ArrayList<>(listeners) ;
        for(MethodExecutionEventListener listener : copyListeners){
            if(MethodExecutionStatus.BEGIN.equals(status)){
                listener.onMethodBegin(methodExecutionEvent);
            }else {
                listener.onMethodEnd(methodExecutionEvent);
            }
        }
    }

    public void addListener(MethodExecutionEventListener listener){
        this.listeners.add(listener) ;
    }
    public void removeListener(MethodExecutionEventListener listener){
        this.listeners.remove(listener) ;
    }
    public void removeAllListeners(){
        this.listeners.clear();
    }
}
