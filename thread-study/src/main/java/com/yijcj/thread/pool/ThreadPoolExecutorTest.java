package com.yijcj.thread.pool;

import lombok.Getter;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws IOException {

        int corePoolSize = 2 ;
        int maximumPoolSize = 4 ;
        long keepAliveTime = 10 ;
        TimeUnit unit = TimeUnit.SECONDS ;
        BlockingQueue<Runnable> workQueue =
                new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameThreadFactory() ;
        RejectedExecutionHandler handler = new MyIgnorePolicy() ;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime,
                unit, workQueue, threadFactory, handler
        ) ;
        executor.prestartAllCoreThreads() ;// 预启动所有核心线程
        for (int i = 0; i <10 ; i++) {
            MyTask task = new MyTask(String.valueOf(i)) ;
            executor.execute(task);
        }
        System.in.read();//阻塞主线程
    }

    static class NameThreadFactory implements ThreadFactory{
        private final AtomicInteger mThreadNum = new AtomicInteger(1) ;
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread("my-thread-" + mThreadNum.getAndIncrement()) ;
            System.out.println(t.getName() + " has bean created");
            return t;
        }
    }

    static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r,executor) ;
        }

        private void doLog(Runnable r, ThreadPoolExecutor executor) {
            //可做日志记录等
            System.err.println(r.toString() + " rejected");
        }
    }

    static class MyTask implements Runnable {
        @Getter
        private String name ;
        public MyTask(String name){
            this.name = name ;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + "is running!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask [name=]" + name +"]" ;
        }
    }

}
