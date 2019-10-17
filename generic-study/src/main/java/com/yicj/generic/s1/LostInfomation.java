package com.yicj.generic.s1;

import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.*;

class Frob{}
class Fnorkle{}
class Quark<Q> {}
class Particle<POSITION,MOMENTUM>{}

//getTypeParameters表示有泛型申明所申明的类型参数..
public class LostInfomation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>() ;
        Map<Frob,Fnorkle> map = new HashMap<>() ;
        Quark<Fnorkle> quark = new Quark<>() ;
        Particle<Long,Double> p = new Particle<>() ;
        System.out.println(Arrays.toString(
            list.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
            map.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
            quark.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
            p.getClass().getTypeParameters()
        ));
    }
}
