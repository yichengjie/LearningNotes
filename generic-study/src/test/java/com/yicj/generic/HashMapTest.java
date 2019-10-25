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

    @Test
    public void test1(){
        float loadFactor = 0.75f ;
        int a = 1 ;
        System.out.println("1 = " + this.ttt(a, loadFactor));
        a = 2 ;
        System.out.println("2 = " + this.ttt(a, loadFactor));
        a = 3 ;
        System.out.println("3 = " + this.ttt(a, loadFactor));
        a = 4 ;
        System.out.println("4 = " + this.ttt(a, loadFactor));
    }

    @Test
    public void test2(){
        //hash值与数组容量计算index
        System.out.println(120 & 14);
        System.out.println(121 & 14);
        System.out.println(123 & 14);
        System.out.println(124 & 14);
        System.out.println(125 & 14);
        System.out.println(126 & 14);
    }

    @Test
    public void test3(){
        byte a = 0b1110 ;
        byte b = 0b0101 ;
        System.out.println(a & b);
    }

    int ttt(int s , float loadFactor){
        float ft = ((float)s / loadFactor) + 1.0F;
        System.out.println("ft : " + ft);
        int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                (int)ft : MAXIMUM_CAPACITY);
        return t ;
    }

    //通过tableSizeFor(int cap)对传入的 容量 取 大于等于 该值 最小的2的指数幂。
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
