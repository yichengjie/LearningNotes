package com.yicj.bridging.demo1;
//抽象来源地A：AreaA
public abstract class AreaA {
    //引用桥接口
    Qiao qiao ;
    abstract void fromAreaA() ;
}

//来源地A1
class AreaA1 extends AreaA{
    @Override
    void fromAreaA() {
        System.out.println("我来自A1");
    }
}
//来源地A2
class AreaA2 extends AreaA{
    @Override
    void fromAreaA() {
        System.out.println("我来自A2");
    }
}
//来源地A3
class AreaA3 extends AreaA{
    @Override
    void fromAreaA() {
        System.out.println("我来自A3");
    }
}
