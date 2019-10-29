package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicReference;
//不可重入，非公平自旋锁
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>() ;
    public void lock (){
        Thread current = Thread.currentThread() ;
        //利用CAS // 如果cas中存在其他线程则返回compareAndSet返回false，则继续循环
        while (!cas.compareAndSet(null,current)){
            // do nothing
        }
    }
    public void  unlock(){
        Thread current = Thread.currentThread() ;
        cas.compareAndSet(current,null) ;
    }
}
