package com.yicj.generic;

import org.junit.Test;

public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void testTableSizeFor(){
        int cap = 1 ;
        System.out.println("1 -> cap : " + this.tableSizeFor(cap));
        cap = 2 ;
        System.out.println("2 -> cap : " + this.tableSizeFor(cap));
        cap = 3;
        /**
         * 1 -> cap : 1
         * 2 -> cap : 2
         * 3 -> cap : 4
         * 4 -> cap : 4
         * 5 -> cap : 8
         * 6 -> cap : 8
         * 7 -> cap : 8
         * 8 -> cap : 8
         * 9 -> cap : 16
         * 10 -> cap : 16
         */
    }




    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
