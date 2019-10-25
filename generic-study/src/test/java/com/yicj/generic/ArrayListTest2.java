package com.yicj.generic;

public class ArrayListTest2 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList() ;
        AbstractList.ListItr listItr = list.listIterator();
        listItr.set("abc");
    }
}

abstract class  AbstractList <E>{
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }
    //public abstract E set(int index, E element) ;
    public class ListItr {
        public void set(E e) {
            System.out.println("AbstractList.this : " + AbstractList.this.getClass().getName());
            AbstractList.this.set(0,e) ;
        }
    }
    public ListItr listIterator(){
        return new ListItr() ;
    }
}

class ArrayList <E>extends AbstractList<E>{
    private Object [] elementData = new Object[10] ;
    public E set(int index, E element) {
        elementData[index] = element ;
        return element ;
    }
}

class ArrayList2 <E>extends AbstractList<E>{
    private Object [] elementData = new Object[10] ;

}


