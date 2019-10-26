package com.yijcj.thread.simple;

public class ThreadLocal1 {

    static class Son implements Cloneable{
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        Son p = new Son() ;
        System.out.println("son : " + p);
        Thread t = new Thread(()-> {
            ThreadLocal<Son> local = new ThreadLocal<>() ;
            System.out.println("local : " + local);
            local.set(p);
            System.out.println("son : " + local.get());
            local.remove();
            try {
                local.set((Son)p.clone());
                System.out.println("son : " + local.get());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println("local: " + local);
        }) ;
        t.start();
    }
}
