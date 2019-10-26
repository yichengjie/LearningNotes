package com.yijcj.thread.simple;

public class ThreadLocal2 {

    static class Son implements Cloneable{
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        ThreadLocal<Son> local = new ThreadLocal<>() ;
        Son p = new Son() ;
        System.out.println("org : son : " + p);
        local.set(p);
        System.out.println("main son : " + local.get());

    }
}
