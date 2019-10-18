package com.yicj.generic.s2;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>() ;
    private void add(T item){
        array.add(item) ;
    }
    public T get(int index){
        return array.get(index) ;
    }
}
