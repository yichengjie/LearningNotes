package com.yicj.generic.s1;

import com.yicj.generic.common.BasicGenerator;
import com.yicj.generic.common.Generator;

public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen =
                BasicGenerator.create(CountedObject.class) ;
        //Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class) ;
        for(int i = 0 ; i< 5 ; i++){
            System.out.println(gen.next());
        }
    }
}
