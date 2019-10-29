package com.yijcj.thread.lock2;

public class CLHLockTest {

    public static void main(String[] args) {
        CLHLock clhLock = new CLHLock() ;
        MyResource resource = new MyResource(clhLock) ;
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0 ; i < 100 ; i++){
                    resource.add();
                }
                System.out.println("--------> " + resource.get());
            }
        } ;
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0 ; i < 100 ; i++){
                    resource.add();
                }
                System.out.println("--------> " + resource.get());
            }
        } ;
        t1.start();
        t2.start();
    }

    static class MyResource{
        private CLHLock clhLock ;
        public MyResource(CLHLock clhLock){
            this.clhLock = clhLock ;
        }
        int i = 0 ;
        public void add(){
            clhLock.lock();
            try {
                Thread.sleep(10);
                i ++ ;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                clhLock.unlock();
            }
        }
        public int get(){
            clhLock.lock();
            try {
                Thread.sleep(10) ;
                return i ;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                clhLock.unlock();
            }
        }
    }
}
