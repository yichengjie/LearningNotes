package com.yicj.container.s1;

import com.yicj.container.common.MapData;
import com.yicj.container.common.Pair;
import com.yicj.generic.common.Generator;

import java.util.Iterator;

class Letters implements
        Generator<Pair<Integer,String>> ,Iterable<Integer>{
    private int size = 9 ;
    private int number = 1 ;
    private char letter = 'A' ;

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++,"" +letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext() {
                return number < size;
            }
            @Override
            public Integer next() {
                return number++;
            }
            public void remove(){
                throw new UnsupportedOperationException() ;
            }
        } ;
    }
}

public class MapDataTest {

    public static void main(String[] args) {
        //Pair Generator
        System.out.println(MapData.map(new Letters(),11));
        System.out.println("====================");
        System.out.println(MapData.map(new Letters(),
                "Pop"));
    }
}
