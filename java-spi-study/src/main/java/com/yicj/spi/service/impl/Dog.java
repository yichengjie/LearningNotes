package com.yicj.spi.service.impl;

import com.yicj.spi.service.IShout;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
