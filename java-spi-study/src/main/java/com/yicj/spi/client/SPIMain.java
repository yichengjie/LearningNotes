package com.yicj.spi.client;

import com.yicj.spi.service.IShout;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class) ;
        for (IShout s : shouts){
            s.shout();
        }
    }
}
