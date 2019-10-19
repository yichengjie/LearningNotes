package com.yicj.container.s1;

import com.yicj.container.common.Deque;

public class DequeTest {

    static void fillTest(Deque<Integer> deque){
        for(int i = 20; i < 27; i++){
            deque.addFirst(i);
        }
        for(int i = 50 ; i < 55; i++){
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> d1 = new Deque<>() ;
        fillTest(d1);
        System.out.println(d1);
        while (d1.size() !=0 ){
            System.out.print(d1.removeFist() +" ");
        }
        System.out.println();
        System.out.println("=============================");
        fillTest(d1);
        while (d1.size() != 0){
            System.out.print(d1.removeLast() +" ");
        }
    }

}
