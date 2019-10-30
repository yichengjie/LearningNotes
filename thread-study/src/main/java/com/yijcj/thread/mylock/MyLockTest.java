package com.yijcj.thread.mylock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyLockTest {
    private static List<Integer> list = new ArrayList<Integer>() ;
    private static MyLock myLock = new MyLock() ;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i = 0 ; i < 10000 ; i ++){
                add(i);
            }
        }) ;
        Thread t2 = new Thread(()->{
            print();
        }) ;
        t1.start();
        t2.start();
    }

    private static void add (int i){
        myLock.lock();
        list.add(i) ;
        myLock.unlock();
    }

    private static void print(){
        myLock.lock();
        Iterator<Integer> iterator = list.iterator() ;
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        myLock.unlock();
    }
}
