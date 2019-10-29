package com.yijcj.thread.api;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {
        //AtomicReference atomicReference = new AtomicReference() ;
        //atomicReference.set("new Object referenced");
        //比较赋值
        String initialReference = "initial value referenced";
        AtomicReference<String> atomicReference = new AtomicReference<>(initialReference) ;
        String newReference = "new value referenced" ;
        boolean exchanged = atomicReference.compareAndSet(initialReference,newReference) ;
        System.out.println("exchanged : " + exchanged + ", value : " + atomicReference.get());
        exchanged = atomicReference.compareAndSet(initialReference,newReference) ;
        System.out.println("exchanged : " + exchanged +" ,value : " + atomicReference.get());
    }

}
