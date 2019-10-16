package com.yicj.classinfo;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    Toy(){}
    Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName() + " is interface ["+cc.isInterface()+"]");
        System.out.println("Simple name : " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null ;
        try {
            c = Class.forName("com.yicj.classinfo.FancyToy") ;
        }catch (ClassNotFoundException e){
            System.err.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        System.out.println("----------------1111111-------------------");
        for(Class face : c.getInterfaces()){
            printInfo(face);
            System.out.println("---------");
        }
        System.out.println("-----------------222222------------------");
        Class up = c.getSuperclass() ;
        Object obj = null ;
        try {
            obj =  up.newInstance() ;
        } catch (InstantiationException e) {
            System.err.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
        boolean f = boolean.class == Boolean.TYPE ;
    }

}
