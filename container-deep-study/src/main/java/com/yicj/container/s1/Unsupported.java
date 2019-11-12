package com.yicj.container.s1;

import java.util.*;

public class Unsupported {

    static void test(String msg, List<String> list){
        System.out.println("--------"+msg+"-----------");
        Collection<String> c = list ;
        List<String> subLists = list.subList(1, 8);
        List<String> c2 = new ArrayList<>(subLists);
        try {
            boolean b = c.retainAll(c2);
        }catch (Exception e){
            System.out.println("retainAll() " + e);
        }

        try {
            boolean b = c.removeAll(c2);
            System.out.println(b);
        }catch (Exception e){
            System.out.println("retainAll() " + e);
        }

        try {
            list.set(1,"X") ;
        }catch (Exception e){
            System.out.println("set() " + e);
        }


    }

    public static void main(String[] args) {
        String msg = "s1" ;
        String [] array = {"1","2","3","4","5","6","7","8"} ;
        List<String> list = Arrays.asList(array) ;
        //List<String> list = new ArrayList<>() ;
        test(msg,list);
        System.out.println("================================");
        List<String> list2 = new ArrayList<>() ;
        list2.add("1") ;
        list2.add("2") ;
        list2.add("3") ;
        list2.add("4") ;
        list2.add("5") ;
        list2.add("6") ;
        list2.add("7") ;
        list2.add("8") ;
        list2.set(1,"Y") ;
        List<String> list3 = new ArrayList<>(list2) ;
        test(msg, Collections.unmodifiableList(list3));

    }
}
