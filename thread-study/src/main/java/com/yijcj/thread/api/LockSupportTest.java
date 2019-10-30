package com.yijcj.thread.api;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {
//        TestLockSupport lockSupport = new TestLockSupport() ;
//        lockSupport.start();

        TestThread thread = new TestThread() ;
        thread.start();
    }

}

class TestLockSupport extends Thread{
    @Override
    public void run() {
        System.out.println("TestLockSupport.run().");
        LockSupport.park();
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("TestThread.run()");
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
