package com.yicj.generic.s3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>() ;
        list.add("beijing") ;
        list.add("tianjing") ;
        list.add("shanghai") ;
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            iter.remove();
            System.out.println(next);
        }
        System.out.println("size : " + list.size());
    }
}
