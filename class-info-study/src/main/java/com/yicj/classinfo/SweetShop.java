package com.yicj.classinfo;

class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy() ;
        System.out.println("After creating Candy");
        try{
            Class.forName("com.yicj.classinfo.Gum") ;
        }catch (ClassNotFoundException e){
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"com.yicj.classinfo.Gum\")");
        new Cookie() ;
        System.out.println("After create Cookie");
        /**
         * inside main
         * Loading Candy
         * After creating Candy
         * Loading Gum
         * After Class.forName("com.yicj.classinfo.Gum")
         * Loading Cookie
         * After create Cookie
         */
    }
}
