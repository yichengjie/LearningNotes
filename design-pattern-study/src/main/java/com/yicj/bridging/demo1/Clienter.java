package com.yicj.bridging.demo1;

public class Clienter {
    public static void main(String[] args) {
        AreaA a = new AreaA2() ;
        a.qiao = new AreaB3() ;
        a.fromAreaA();
        a.qiao.targetAreaB();
    }
}
