package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicReference;

//可重入，非公平自旋锁
public class ReentrantSpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>() ;
    private int count ;
    public void lock(){
        Thread current = Thread.currentThread() ;
        if(current == cas.get()){ //如果当前线程已经获取到了锁，线程数增加1，然后返回
            count ++ ;
            return;
        }
        //如果没有获取到锁，则通过CAS自旋
        while (!cas.compareAndSet(null,current)){
            // do nothing
        }
    }

    public void unlock(){
        Thread cur = Thread.currentThread() ;
        if(cur == cas.get()){
            if (count > 0) { //如果大于0,表示当前线程获取了该锁，释放锁通过count减1来模拟
                count--;
            } else {//如果count == 0,可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的
                cas.compareAndSet(cur,null) ;
            }
        }
    }

}
