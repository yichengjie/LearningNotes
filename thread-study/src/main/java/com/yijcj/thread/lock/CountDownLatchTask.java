package com.yijcj.thread.lock;

import com.yijcj.thread.mylock.ThreadList;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTask {


    public static void main(String[] args) {
        CountDownLatchTask task = new CountDownLatchTask() ;
        task.startThreads(5);
    }

    private void startThreads(int threadNumber){
        CountDownLatch latch = new CountDownLatch(threadNumber) ;
        for (int i = 0; i < threadNumber; i++) {
            new Thread(()->{
                System.out.println("线程算法实现：" + Thread.currentThread().getName());
                latch.countDown();
            }).start() ;
        }
        try {
            latch.await();
            System.out.println("加权求平均数!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
