package com.yicj.s1;

public class StopWatch {
    private Long t1 ;
    private Long t2 ;

    public void start(){
        t1 = System.currentTimeMillis() ;
    }
    public void stop(){
        t2 = System.currentTimeMillis() ;
    }

    @Override
    public String toString() {
        return String.format("方法耗时[%d]毫秒",(t2 - t1)) ;
    }
}
