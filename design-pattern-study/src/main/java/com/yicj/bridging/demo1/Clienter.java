package com.yicj.bridging.demo1;
//https://www.cnblogs.com/V1haoge/p/6497919.html
public class Clienter {
    public static void main(String[] args) {
        AreaA a = new AreaA2() ;
        a.qiao = new AreaB3() ;
        a.fromAreaA();
        a.qiao.targetAreaB();
    }
}
