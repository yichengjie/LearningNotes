package com.yicj.s2.service.impl;

import com.yicj.s2.service.ITester;
import lombok.Setter;

public class Tester implements ITester {
    @Setter
    private boolean busyAsTester ;

    @Override
    public boolean isBusyTester() {
        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("I will ensure the quality.");
    }
}
