package com.yicj.s1.service.impl;

import com.yicj.s1.service.ITester;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tester implements ITester {
    private boolean busyAsTester ;
    @Override
    public void testSoftware() {
        log.info("I will ensure the quality.");
    }
    @Override
    public boolean isBusyAsTester() {
        return busyAsTester;
    }
    public void setBusyAsTester(boolean busyAsTester){
        this.busyAsTester = busyAsTester ;
    }
}
