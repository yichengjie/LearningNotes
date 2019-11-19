package com.yicj.s3.service.impl;

import com.yicj.s3.service.ICounter;

public class CounterImpl implements ICounter {
    private int counter ;
    @Override
    public void resetCounter() {
        counter = 0 ;
    }

    @Override
    public int getCounter() {
        counter ++ ;
        return counter ;
    }
}
