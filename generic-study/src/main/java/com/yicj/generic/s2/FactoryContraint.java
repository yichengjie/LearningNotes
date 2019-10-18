package com.yicj.generic.s2;

//InstantiateGenericType不在编译期捕获错误，所以Sun的伙计对这种方式并不赞同
//他们建议使用显式工厂，并将限制其类型，使得只能接受现实了这个工厂的类

interface FactoryI<T>{
    T create() ;
}

class Foo2<T>{
    private T x ;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create() ;
    }
}

class IntegerFactory implements FactoryI<Integer>{
   @Override
    public Integer create() {
        return new Integer(0) ;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryContraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory()) ;
        new Foo2<Widget>(new Widget.Factory()) ;
    }
}
