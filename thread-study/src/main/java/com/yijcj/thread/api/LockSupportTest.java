package com.yijcj.thread.api;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.LockSupport;
//测试：先unpark，后park
//先执行unpark，再调用park，直接就没有被阻塞，
// 因此park/unpark相比较wait/notify更加的灵活
public class LockSupportTest {

    public static void main(String[] args) {
        TestThread thread = new TestThread(Thread.currentThread()) ;
        long start = System.nanoTime() ;
        thread.start();
        try {
            Thread.sleep(1000) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before part");
        //等待获取许可
        LockSupport.park("Park");
        System.out.println("after park " + (System.nanoTime() - start));
        /**
         * before unpark
         * after unpark
         * before part
         * after park 990178700
         */
    }

    static class TestThread extends Thread{
        private Object object ;
        public TestThread(Object object){
            this.object = object ;
        }
        @Override
        public void run() {
            System.out.println("before unpark");
            LockSupport.unpark((Thread) object);
            System.out.println("after unpark");
        }
    }

}

