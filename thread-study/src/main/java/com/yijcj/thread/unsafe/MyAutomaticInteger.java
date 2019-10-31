package com.yijcj.thread.unsafe;

import sun.misc.Unsafe;
public class MyAutomaticInteger {
    private volatile int value = 0;
    private Unsafe unsafe;
    private long offset;
    public MyAutomaticInteger(Unsafe unsafe) throws Exception {
        this.unsafe = unsafe;
        this.offset = unsafe.objectFieldOffset(MyAutomaticInteger.class.getDeclaredField("value"));
    }


    public void increment(){
        int oldValue = value ;
        for(;;){
            if(unsafe.compareAndSwapInt(this,offset,oldValue,oldValue +1)) {
                break;
            }
            oldValue = value ;
        }
    }

    public int getAddIncrement(){
        int oldValue = value ;
        for(;;){
            if(unsafe.compareAndSwapInt(this,offset,oldValue,oldValue +1)){
                return oldValue;
            }
            oldValue = value ;
        }
    }

    public int getValue (){
        return  value ;
    }
}
