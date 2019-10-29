package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//CLHLock锁是一种基于链表的可扩展，高性能的自旋锁，申请线程只在本地变量上自旋，
//它不断的轮询前驱的状态，如果发现前驱释放了锁就结束自旋，获得锁
//https://blog.csdn.net/qq_34337272/article/details/81252853
public class CLHLock {

    //定义一个节点,默认的lock状态为true
    public static class CLHNode{
        private volatile boolean isLocked = true ;
    }

    //尾部节点，只用一个节点即可
    private volatile CLHNode tail ;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>() ;
    private static final AtomicReferenceFieldUpdater<CLHLock,CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class,CLHNode.class,"tail") ;

    public void lock(){
        //新建节点并将节点与当前线程保存起来
        CLHNode node = new CLHNode() ;
        LOCAL.set(node);
        //将新建的节点设置为尾部节点，并返回旧节点(原子操作)，
        //这里旧的节点实际上就是当前节点的前驱节点
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if(preNode != null){
            //前驱节点不为null表示锁被其他线程占用,通过不断轮询判断
            //前驱节点锁的标志位等待前驱节点释放锁
            while (preNode.isLocked){
                System.out.println("-----------------");
                //do noting
            }
            preNode = null ;
            LOCAL.set(node);
        }
        //如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程释放锁
    }
    public void unlock(){
        //获取当前线程对应的节点
        CLHNode node = LOCAL.get() ;
        //如果tail节点等于node,则将tail节点更新为null，
        //同时将node的lock状态设置为false，表示当前线程释放了锁
        //这里感觉有问题
        boolean flag = UPDATER.compareAndSet(this, node, null);
        //System.out.println("release tail节点flag : " + flag);
        if(!flag){
            node.isLocked = false ;
        }
        /*boolean flag = UPDATER.compareAndSet(this, node, null);
        System.out.println(Thread.currentThread().getName() + "release : " + flag);
        node.isLocked = false ;*/
        node = null ;
    }
}
