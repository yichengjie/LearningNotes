package com.yijcj.thread.future;

import java.util.concurrent.*;

public class FutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<String> future = pool.submit(new MyTask());
        String s1 = future.get();
        System.out.println("s1 : " + s1);
        String s2 = future.get();
        System.out.println("s2 : " + s2);
        pool.shutdown();
    }


    static class MyTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(3);
            return "hello world";
        }
    }
}
