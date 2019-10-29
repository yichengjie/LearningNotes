package com.yicj.thread.api;

import com.yijcj.thread.api.CLHLock;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CLHLockTest {
    private int count = 0 ;
    @Test
    public void test1() throws InterruptedException {
        CLHLock lock = new CLHLock() ;
        new Thread(()->{
            for(int i = 0 ; i < 10 ; i++){
                add(lock);
            }
            //latch.countDown();
        },"线程一").start();
        new Thread(()->{
            for(int i = 0 ; i < 10 ; i++){
                add(lock);
            }
            //latch.countDown();
        },"线程二").start();
        //latch.await();
    }


    private void add(CLHLock lock){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "对count 加 1 ");
            Thread.sleep(1);
            count ++ ;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
