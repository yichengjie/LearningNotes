package com.yijcj.thread.api;

import java.util.concurrent.locks.LockSupport;

//interrupt与unpark
public class LockSupportTestV4 {

    public static void main(String[] args) throws InterruptedException {
        TestThread thread = new TestThread() ;
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }


    static class TestThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}

