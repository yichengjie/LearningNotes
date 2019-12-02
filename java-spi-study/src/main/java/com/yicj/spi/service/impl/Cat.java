package com.yicj.spi.service.impl;

import com.yicj.spi.service.IShout;

public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
