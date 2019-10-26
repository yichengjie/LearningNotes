package com.yicj.generic;

import org.junit.Test;

public class LinkedListTest <E>{

    @Test
    public void test1(){
        E [] arr = null ;
        ttt(arr);
    }

    private void ttt(E [] arr){
        Object [] b = arr ;
        b[0] = 1 ;
        b[1] = "str" ;
    }
}
