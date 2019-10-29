package com.yijcj.thread.lock2;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock {
    private final ThreadLocal<Node> prev ;//保存当前线程的前继节点
    private final ThreadLocal<Node> node ;//保存当前线程的节点
    //类在初始化时会初始化tail节点，相当于head节点(注意对隐式队列的理解)
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node()) ;

    public CLHLock(){
        this.prev =  ThreadLocal.withInitial(()->null) ;
        this.node = ThreadLocal.withInitial(()->new Node()) ;
    }

    public void lock(){
        Node node = this.node.get() ;//获取Threadlocal变量，每个线程私有
        node.lock = true ;
        //CAS方式设置tail节点，设置成功，相当于加入队列
        Node pred = this.tail.getAndSet(node) ;
        //把之前的tail节点存入自己的prev节点，并循环访问其lock标志位，等待释放
        this.prev.set(pred);
        while (pred.lock) ;
    }

    public void unlock(){
        Node node = this.node.get() ;
        node.lock = false ;
        //线程释放锁之后，将当前节点设置为前继节点，相当于队列的出队(利于GC)
        this.node.set(this.prev.get());
    }

    private class Node{
        //默认初始化值为false
        private volatile boolean lock ;
    }
}
