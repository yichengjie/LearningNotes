package com.yijcj.thread.mylock;

import lombok.Getter;
import lombok.Setter;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;


//insert方法将线程封装到Node中，然后使用cas操作将node添加到列表的头部
//栈的数据结构，先进后出
public class ThreadList {
    private volatile Node head = null ;
    private static long headOffset ;
    private static Unsafe unsafe ;
    static {
        try {
            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor(new Class<?>[0]) ;
            constructor.setAccessible(true);
            unsafe = constructor.newInstance(new Object[0]) ;
            headOffset = unsafe.objectFieldOffset(ThreadList.class.getDeclaredField("head")) ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //是否只有当前一个线程在等待
    //insert时将新节点设置为head，即为链表的首元素
    public boolean insert(Thread thread){
        Node node = new Node(thread) ;
        for(;;){
            Node first = getHead() ;
            node.setNext(first);
            //如果head目前任然为等于first点的话，将node赋值给head
            //ThreadList.insert返回boolean类型的值，用来处理当前只有一个等待的线程时，
            // 重新获取以下锁，防止永远不被唤醒
            if(unsafe.compareAndSwapObject(this,headOffset,first,node)){
                return first == null ;
            }
        }
    }
    //pop时将head取出，然后将head的下一个节点设置为head
    //并返回head对应的线程对象
    public Thread pop(){
        Node first = null ;
        for(;;){
            first = getHead() ;
            Node next = null ;
            if(first != null){
                next = first.getNext() ;
            }
            if(unsafe.compareAndSwapObject(this,headOffset,first,next)){
                break;
            }
        }
        return first == null ? null : first.getThread();
    }

    private Node getHead() {
        return this.head ;
    }

    private static class Node {
        @Getter
        @Setter
        volatile Node next  ;
        @Getter
        volatile Thread thread ;
        public Node(Thread thread){
            this.thread = thread ;
        }
    }
}
