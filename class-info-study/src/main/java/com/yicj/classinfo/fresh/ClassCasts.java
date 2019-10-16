package com.yicj.classinfo.fresh;

class Building{}
class House extends Building{}

public class ClassCasts {

    public static void main(String[] args) {
        Building b = new Building() ;
        Class<House> houseType = House.class ;
        House h = houseType.cast(b) ;
        h = (House) b; // ... or just do this
        //houseType.isInstance(b) ;
        //将一个类对象转型为更加具体的类型
        //houseType.asSubclass() ;
    }
}
