package com.yicj.container.s1;

import java.util.BitSet;
import java.util.Random;

public class Bits {
    public static void printBitSet(BitSet b){
        System.out.println("bits : " + b);
        StringBuilder bbits = new StringBuilder() ;
        for(int j = 0 ; j < b.size() ; j ++){
            boolean a = b.get(j) ;
            bbits.append(b.get(j) ? "1" : "0") ;
        }
        System.out.println("bit pattern : " + bbits);
    }

    public static void main(String[] args) {
        Random rand = new Random(47) ;
        byte bt = (byte)rand.nextInt() ;
        BitSet bb = new BitSet() ;
        //System.out.println("size : " + bb.size());
//        for(int i = 7 ; i >= 0 ; i--){
//            if( ((1 << i ) & bt) != 0 ){
//                System.out.println("---set--> " + i);
//                bb.set(i);
//            }else {
//                System.out.println("---remove--> " + i);
//                bb.clear(i);
//            }
//        }
//        System.out.println("byte value : " + bt);
//
//        printBitSet(bb);
         int t = ((1 << 6 ) & bt) ;
        System.out.println(t);
    }

    //0 - 1
    //1 - 0
    //2 - 4
    //3 - 0
    //4 - 16
    //5 - 0
    //6 - 0
    //7 - 0


}
