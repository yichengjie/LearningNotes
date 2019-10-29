package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//MCSLock则是对本地变量的节点进行循环
public class MCSLock {

    //节点，记录当前节点的锁状态以及后驱节点
    public static class MCSNode{
        volatile MCSNode next ;
        volatile boolean isLocked = true ;
    }

    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<>() ;
    //队列
    private volatile MCSNode queue ;
    //queue 更新器
    private static final AtomicReferenceFieldUpdater<MCSLock,MCSNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class,"queue") ;
    public void lock(){
        //创建节点并保存到ThreadLocal中
        MCSNode currentNode = new MCSNode() ;
        NODE.set(currentNode);
        //将queue设置为当前节点,且返回之前的节点
        MCSNode preNode = UPDATER.getAndSet(this,currentNode) ;
        if(preNode != null){
            //如果之前的节点不为null，表示锁已经被其他线程持有
            preNode.next = currentNode ;
            //循环判断，直到当前节点的锁标志位为false
            while (currentNode.isLocked){
                //do nothing
            }
        }
    }

    public void unlock(){
        MCSNode currentNode = NODE.get() ;
        //next 为null表示没有正在等待获取锁的线程
        if(currentNode.next == null){
            //更新状态并设置queue为null
            if(UPDATER.compareAndSet(this,currentNode,null)){
                //如果成功，表示queue==currentNode,即当前节点后面没有节点了
                return;
            }else {
                //如果不成功，表示queue!=currentNode,即当前节点后面多了一个节点
                //表示有线程在等待
                //如果当前节点的后续节点为null，则需要等待其不为null
                while (currentNode.next ==null){}
            }
        }else {
            //如果不为null,表示有线程在等待获取锁，此时将等待线程对应节点锁状态更新为false,
            //同时将当前线程的后继节点设置为null
            currentNode.next.isLocked = false ;
            currentNode.next = null ;
        }
    }

}
