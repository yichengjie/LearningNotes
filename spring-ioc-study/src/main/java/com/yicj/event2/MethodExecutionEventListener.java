package com.yicj.event2;

import java.util.EventListener;

public interface MethodExecutionEventListener extends EventListener {
    //处理方法开始执行的时候发布的MethodExecutionEvent事件
    void onMethodBegin(MethodExecutionEvent evt) ;
    //处理方法将执行结束时候发布的MethodExecutionEvent事件
    void onMethodEnd(MethodExecutionEvent evt) ;
}
