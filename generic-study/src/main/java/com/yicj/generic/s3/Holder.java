package com.yicj.generic.s3;


class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class Holder<T> {
    private T value ;
    public Holder(){}
    public Holder(T val){
        this.value = val ;
    }
    public void set(T val){
        this.value = val ;
    }
    public T get(){
        return this.value ;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj) ;
    }

    public static void main(String[] args) {

        Holder<Apple> appleHolder = new Holder<>(new Apple()) ;
        Apple d = appleHolder.get();
        appleHolder.set(d);
        // Cannot upcast
        //Holder<Fruit> fruitHolder = appleHolder ;
        Holder<? extends Fruit> fruitHolder = appleHolder ;
        Fruit p = fruitHolder.get() ;
        d = (Apple) fruitHolder.get() ;
        try {
            Orange c = (Orange)fruitHolder.get() ;
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(fruitHolder.equals(d));
        //set()不能工作与Apple或Fruit，因为set()的参数为‘? extends Fruit’
        // 这意味着它可以是任何的事物，而编译器无法验证'任何事物'的类型安全性

        //fruitHolder.set(new Fruit());

    }
}
