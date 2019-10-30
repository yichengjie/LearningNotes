package com.yijcj.thread.api;

import java.util.concurrent.locks.LockSupport;

//先park后unpark
public class LockSupportTestV2 {

    public static void main(String[] args) {
        TestThread thread = new TestThread(Thread.currentThread()) ;
        thread.start();
        System.out.println("before park");
        //等待获取许可
        LockSupport.park("Park");
        System.out.println("after park");
    }

    static class TestThread extends Thread{
        private Object object ;
        public TestThread (Object object){
            this.object = object ;
        }
        @Override
        public void run() {
            System.out.println("before unpark");
            //休眠，保证setBlocker(t,blocker)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取blocker
            System.out.println("Blocker info : " + LockSupport.getBlocker((Thread)object));
            //释放许可
            LockSupport.unpark((Thread)object);
            //休眠500ms，保证先执行park中的setBlocker(t,null)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Blocker info : " + LockSupport.getBlocker((Thread)object));
            System.out.println("after unpark");
        }
    }
}
