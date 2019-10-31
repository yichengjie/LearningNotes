package com.yijcj.thread.treiberstack;

import java.util.concurrent.atomic.AtomicReference;


//JDK中的使用
//JDK中的FutureTask使用了Treiber Stack。关于FutureTask的源码解读，可以参考我的博文FutureTask源码解读。
//FutureTask用了Treiber Stack来维护等待任务完成的线程，
//在FutureTask的任务完成/取消/异常后在finishCompletion钩子方法中会唤醒栈中等待的线程。
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> top = new AtomicReference<Node<E>>() ;

    public void push(E item){
        Node<E> newHead = new Node<>(item) ;
        Node<E> oldHead ;
        do{
          oldHead = top.get() ;
          newHead.next = oldHead ;
        }while (!top.compareAndSet(oldHead,newHead)) ;
    }

    public E pop(){
        Node<E> oldHead ;
        Node<E> newHead ;
        do {
            oldHead = top.get() ;
            if(oldHead == null){
                return null ;
            }
            newHead = oldHead.next ;
        }while (!top.compareAndSet(oldHead,newHead)) ;
        return oldHead.item ;
    }
    private static class Node<E>{
        public final E item ;
        public Node<E> next ;
        public Node(E item){
            this.item = item ;
        }
    }
}
