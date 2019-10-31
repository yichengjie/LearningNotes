package com.yijcj.thread.cyclicbarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3) ;
        Thread t1 = new Thread(()->{
            int g2 = 0;
            try {
                g2 = barrier.await();
                System.out.println("g2 : " + g2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }) ;

        Thread t2 = new Thread(()->{
            int g3 = 0;
            try {
                g3 = barrier.await();
                System.out.println("g3 : " + g3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }) ;
        t1.start();
        t2.start();
        int count = 0 ;
        for(int i = 0 ; i < 100 ; i++){
            count += i ;
        }
        int g1 = barrier.await();
        System.out.println("g1 : " + g1);
    }

}
