package com.yijcj.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class CLHLock  implements Lock {
    private AtomicReference<QNode> tail ;
    private ThreadLocal<QNode> myPred ;
    private ThreadLocal<QNode> myNode ;

    public CLHLock(){
        tail = new AtomicReference(new QNode()) ;
        myNode = ThreadLocal.withInitial(()->new QNode()) ;
        myPred = ThreadLocal.withInitial(()-> null) ;
    }

    @Override
    public void lock() {
        QNode qnode = myNode.get() ;
        qnode.locked = true ;
        QNode pred = tail.getAndSet(qnode) ;
        myPred.set(pred);
        while (pred.locked){}//等待前驱节点的locked域变为false
    }

    @Override
    public void unlock() {
        QNode qnode = myNode.get() ;
        qnode.locked = false ;
        myNode.set(myPred.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
