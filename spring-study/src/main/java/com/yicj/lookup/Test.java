package com.yicj.lookup;

import com.yicj.lookup.entity.Car;
import com.yicj.lookup.entity.Taxi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/yicj/lookup/beans.xml") ;
        Car car1 = context.getBean(Car.class) ;
        Car car2= context.getBean(Car.class) ;
        System.out.println("Car:singleton，所以car1=car2"+ (car1 == car2));
        Taxi taxi1 = car1.getTaxi();
        Taxi taxi2 = car2.getTaxi();
        System.out.println("Taxi:prototype,Car:singleton," +
                "未使用lookup-method注入所以car1==car2应该为" + (taxi1 == taxi2));
        //注意:这里是通过createDog()方法获取
        Taxi taxi3 = car1.createTaxi();
        Taxi taxi4 = car2.createTaxi();
        System.out.println("Taxi:prototype,Car:singleton," +
                "使用了lookup-method注入所以dog3==dog4应该为" + (taxi3 == taxi4));

    }
}
