package com.yicj.generic.s1;

import com.yicj.generic.common.Generator;

import java.util.Iterator;
import java.util.Random;

class Coffee{
    private static long count = 0 ;
    private final long id = count ++ ;
    @Override
    public String toString() {
        return getClass().getSimpleName() +" " + id ;
    }
}
class Latte extends Coffee{}
class Mocha extends Coffee{}
class Cappuccinfo extends Coffee{}
class Americano extends Coffee{}
class Breve extends Coffee{}

public class CoffeeGenerator
        implements Generator<Coffee>,Iterable<Coffee> {
    private Class [] types = {Latte.class,Mocha.class,
        Cappuccinfo.class,Americano.class,Breve.class} ;
    private static Random random = new Random(47) ;
    private int size = 0 ;
    public CoffeeGenerator(){}
    public CoffeeGenerator(int sz){
        this.size = sz ;
    }
    @Override
    public Coffee next() {
        try {
            int index = random.nextInt(types.length);
            Class clazz = types[index];
            return (Coffee) clazz.newInstance() ;
        }catch (Exception e){
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size ;
        @Override
        public boolean hasNext() {
            return count > 0 ;
        }

        @Override
        public Coffee next() {
            count -- ;
            return CoffeeGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator() ;
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }

}
