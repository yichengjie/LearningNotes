package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicInteger;

//线程获取锁之后，将它的排队号返回，等待线程释放锁的时候，需要将该排队号传入，
//但这样是有风险的，因为这个排队号是可以被修改的，一旦被不小心修改了，
//那么锁将不能被正确的释放
public class TicketLock {
    //服务号
    private AtomicInteger serviceNum = new AtomicInteger() ;
    //排队号
    private AtomicInteger ticketNum = new AtomicInteger() ;
    //lock: 获取锁，如果获取成功，返回当前线程的排队号，获取排队号用于释放锁
    public int lock(){
        int currentTickNum = ticketNum.incrementAndGet() ;
        while (currentTickNum!=serviceNum.get()){
            //do nothing
        }
        return currentTickNum ;
    }
    //unlock:释放锁,传入当前持有锁的线程排队号
    public void unlock(int ticketnum){
        serviceNum.compareAndSet(ticketnum,ticketnum +1) ;
    }
}
