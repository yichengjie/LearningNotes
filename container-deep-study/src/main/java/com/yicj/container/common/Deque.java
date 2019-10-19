package com.yicj.container.common;

import java.util.LinkedList;

public class Deque<T> {
    public LinkedList<T> deque = new LinkedList<>() ;
    public void addFirst(T e){
        deque.addFirst(e) ;
    }
    public void addLast(T e){
        deque.addLast(e);
    }
    public T getFirst(){
        return deque.getFirst() ;
    }
    public T getLast(){
        return deque.getLast() ;
    }
    public T removeFist(){
        return deque.removeFirst() ;
    }
    public T removeLast(){
        return deque.removeLast() ;
    }
    public int size(){
        return deque.size() ;
    }

    @Override
    public String toString() {
        return deque.toString() ;
    }
}
