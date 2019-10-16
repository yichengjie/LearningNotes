package com.yicj.classinfo.fresh;


class Individual{
    private static int counter = 0 ;
    private int id  = counter ++ ;
}

class Pet extends Individual{

}

class Dog extends Pet{

}

class Mutt extends Dog{

}
class  Pug extends Dog{

}

public class InstanceofTest {

    public static void main(String[] args) {

        Object obj = null;
        //instanceof判断类型
        if(obj instanceof Dog){
            System.out.println("Dog");
        }else if(obj instanceof Pug){
            System.out.println("Pug");
        }
        //动态instanceof
        // Class.isInstance方法提供了一种动态检测对象的途径,
        // 于是那些单调的instanceof语句都可以使用Class.isInstance替换
        Class<?> clazz = null ;
        boolean instance = clazz.isInstance(obj);
        if(instance){
            System.out.println("do something ");
        }

    }

}
