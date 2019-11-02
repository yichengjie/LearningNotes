package com.yicj.bridging.demo1;

//桥接口：Qiao
public interface Qiao {
    //目的地B
    void targetAreaB() ;
}
//目的地B1
class AreaB1 implements Qiao{
    @Override
    public void targetAreaB() {
        System.out.println("我要去B1");
    }
}
//目的地B2
class AreaB2 implements Qiao{
    @Override
    public void targetAreaB() {
        System.out.println("我要去B2");
    }
}
//目的地B3
class AreaB3 implements Qiao{
    @Override
    public void targetAreaB() {
        System.out.println("我要去B3");
    }
}