package com.yijcj.thread.simple;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    @AllArgsConstructor
    @Data
    static class Car {
        private double price;
        private String color;
        @Override
        public String toString() {
            return "car costs $" + price;
        }
    }

    static class WeakReferenceNode extends WeakReference<Car> {
        @Getter
        private String username ;
        //@Getter
        //private Car car ; //注意这里不要使用变量保存car，否则一直不能被回收
        public WeakReferenceNode(Car car,String username) {
            super(car);
            this.username = username ;
        }
    }

    public static void main(String[] args) {
        //test1() ;
        test2() ;
    }

    private static void test1(){
        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);
        int i=0;
        while(true){
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }

    private static void test2(){
        Car car = new Car(22000,"silver") ;
        WeakReference<Car> weakCar = new WeakReferenceNode(car,"张三") ;
        int i = 0 ;
        while (true){
            if(weakCar.get() != null){
                i ++ ;
                System.out.println("Object is alive for " +i+ " loops " + weakCar);
            }else {
                System.out.println("Object has been collected.");
                break;
            }
        }
        System.out.println("end car : " + car);

    }

}
