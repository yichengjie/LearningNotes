package com.yicj.classinfo.fresh;

import com.yicj.classinfo.pets.model.Cat;
import com.yicj.classinfo.pets.model.Dog;
import com.yicj.classinfo.pets.model.Pet;

import java.util.Arrays;
import java.util.List;

public class GeneriTest {

    public static void main(String[] args) {
//        test1() ;
        test2() ;
    }

    //能正常运行
    public static void test1(){
        List<Class<? extends Pet>> ttt = Arrays.asList(
                Pet.class,Dog.class, Cat.class
        ) ;
        System.out.println(ttt);
    }

    //编辑报错，如果只有一个元素
    public static void test2(){
//        List<Class<? extends Pet>> ttt = Arrays.asList(
//                Dog.class
//        ) ;
       // System.out.println(ttt);
    }

    //运行报错
    public static void test3(){
        List<Class<? extends Pet>> ttt = Arrays.asList(
                Pet.class,Dog.class, Cat.class
        ) ;
        ttt.add(Pet.class) ;
        System.out.println(ttt);
    }
}
