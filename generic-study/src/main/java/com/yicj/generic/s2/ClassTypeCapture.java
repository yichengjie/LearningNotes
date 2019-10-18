package com.yicj.generic.s2;

class Building{}
class House extends Building{}
//擦除的补偿
public class ClassTypeCapture<T> {
    Class<T> kind ;
    public ClassTypeCapture(Class<T> kind){
        this.kind = kind ;
    }
    public boolean f(Object obj){
        return kind.isInstance(obj) ;
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<>(Building.class) ;
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        System.out.println("===========================");
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<>(House.class) ;
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }

}
