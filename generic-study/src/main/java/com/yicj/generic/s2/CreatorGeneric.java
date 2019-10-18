package com.yicj.generic.s2;

//模板设计模式
//get是模板方法，而create是在子类中定义的，用来产生子类类型的对象
abstract class GenericWithCreate<T>{
    final T element ;
    GenericWithCreate(){
        element = create() ;
    }
    abstract T create() ;
}

class X {}

class Creator extends GenericWithCreate<X>{
    @Override
    X create() {
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator() ;
        c.f();
    }
}
