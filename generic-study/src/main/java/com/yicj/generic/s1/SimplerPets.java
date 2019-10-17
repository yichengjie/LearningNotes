package com.yicj.generic.s1;

import com.yicj.classinfo.pets.model.Person;
import com.yicj.classinfo.pets.model.Pet;
import com.yicj.generic.common.New;

import java.time.Period;
import java.util.List;
import java.util.Map;

public class SimplerPets {

    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPerson =
                New.map();
    }
}

class LimitsOfInference{
    static void f(Map<Person,List<? extends Pet>> petPerson){ }

    public static void main(String[] args) {
        //1.8之前不能正确的推断
        //f(New.map()) ; // Does not compile
    }
}

//在泛型方法中，可以显示的指明类型，不过这种语法很少使用。要显式指明类型，
// 必须在点操作符与方法名之间插入尖括号，然后把类型置于尖括号内.
//如果是在定义该方法的类的内部，必须在点操作符之前使用this关键字
//如果是使用static的方法，必须在点操作符之前加上类名


//显式的类型说明
class ExplicitTypeSpecification {
    static void f(Map<Person,List<Pet>> petPerson){}

    public static void main(String[] args) {
        //1.8之前可以显示可以显式指明类型
        f(New.<Person,List<Pet>>map()) ;
    }
}

