package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicInteger;

//将每个线程的排队号放到ThreadLocal中
//TickLock存在的问题:
//    多处理器系统上，每个进程/线程占用的处理器都在读写同一个变量serviceNum ，
//    每次读写操作都必须在多个处理器缓存之间进行缓存同步，这会导致繁重的系统总线和内存的流量，
//    大大降低系统整体的性能。
public class TicketLockV2 {
    //服务号
    private AtomicInteger serviceNum = new AtomicInteger() ;
    //排队号
    private AtomicInteger ticketNum = new AtomicInteger() ;
    //新增一个ThreadLocal，用于存储背个线程的排队号
    private ThreadLocal<Integer> ticketHolder = new ThreadLocal<>() ;

    public void lock(){
        int currentTickNum = ticketNum.incrementAndGet() ;
        //获取锁的时候，将当前线程的排队号保存起来
        ticketHolder.set(currentTickNum);
        while (currentTickNum != serviceNum.get()) {
            // do nothing
        }
    }
    public void unlock(){
        //释放锁，从ThreadLocal中索取当前线程的排队号
        Integer currentTickNum = ticketHolder.get() ;
        serviceNum.compareAndSet(currentTickNum,currentTickNum +1) ;
    }
}
