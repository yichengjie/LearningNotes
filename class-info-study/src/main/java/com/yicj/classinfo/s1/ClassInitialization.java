package com.yicj.classinfo.s1;

import java.util.Random;

class Initable {
    static final int staticFinal = 47 ;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000) ;
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal = 147 ;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 74 ;
    static {
        System.out.println("Initializing Initable3");
    }
}



public class ClassInitialization {
    public static Random rand = new Random(47) ;
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Initable> initable = Initable.class;
        System.out.println("After creating initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println("-------------------------");
        System.out.println(Initable2.staticNonFinal);
        System.out.println("--------------------------");
        Class initable3 =  Class.forName("com.yicj.classinfo.s1.Initable3") ;
        System.out.println("After creating Initable3 ref ");
        System.out.println(Initable3.staticNonFinal);
    }

}
