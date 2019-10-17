package com.yicj.generic.s2;

import com.yicj.classinfo.s1.FilledList;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {

    List<T> create(T t ,int n){
       List<T> result = new ArrayList<>() ;
       for(int i = 0 ; i < n ; i++){
           result.add(t) ;
       }
       return result ;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker =
                new FilledListMaker<>() ;
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }
}
