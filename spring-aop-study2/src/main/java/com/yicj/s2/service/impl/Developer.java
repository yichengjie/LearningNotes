package com.yicj.s2.service.impl;

import com.yicj.s2.service.IDeveloper;

public class Developer implements IDeveloper {
    @Override
    public void developSoftware() {
        System.out.println("I am happy with programming.");
    }
}
