package com.yicj.replaced.busi;

//主要作用就是替换方法体及其返回值，其实现也比较简单
public class OriginalDog {
    public void sayHello(){
        System.out.println("Hello , I am a black dog ...");
    }
    public void sayHello(String name){
        System.out.println("Hello , I am a black dog. " +
                "my name is " + name);
    }
}
