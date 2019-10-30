package com.yijcj.thread.mylock;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.util.concurrent.locks.LockSupport;
//https://www.cnblogs.com/qingquanzi/p/8274078.html
public class MyLock {
    private volatile int state = 0 ;
    private ThreadList threadList = new ThreadList() ;
    private static long stateOffset ;
    private static Unsafe unsafe ;
    static {
        try {
            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor(new Class<?>[0]) ;
            constructor.setAccessible(true);
            unsafe = constructor.newInstance(new Object[0]) ;
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state")) ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //线程使用lock方法进行加锁，cas将state从0修改1，
    // 修改成功则加锁成功，lock方法返回，
    // 否则调用addNodeAndWait方法将线程加入ThreadList队列,
    // 并使用LockSupport将线程挂起
    public void lock(){
        if(!compareAndSetState(0,1)){
            addNodeAndWait() ;
        }
    }

    public void unlock(){
        compareAndSetState(1,0) ;
        Thread thread = threadList.pop() ;
        if(thread != null){
            LockSupport.unpark(thread);
        }
    }

    private void addNodeAndWait(){
        //如果当前只有一个等待线程时，重新获取以下锁，防止永远不被唤醒
        boolean isOnlyOne = threadList.insert(Thread.currentThread()) ;
        if(isOnlyOne && compareAndSetState(0,1)){
            return;
        }
        LockSupport.park(this);//线程被挂起
        if(compareAndSetState(0,1)){//线程被唤醒后继续竞争锁
            return;
        }else {
            addNodeAndWait();
        }
    }

    private boolean compareAndSetState(int expect , int update){
        return unsafe.compareAndSwapInt(this,stateOffset,expect,update) ;
    }


}
