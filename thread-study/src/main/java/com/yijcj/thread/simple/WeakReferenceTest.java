package com.yijcj.thread.simple;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

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

    @Data
    @AllArgsConstructor
    @ToString
    static class Person {
       private String username ;
       private String addr ;
    }

    static class WeakReferenceNode<K,V> extends WeakReference<K> {
        @Getter
        private V value ;
        //1.注意 这里不要使用变量保存car，否则一直不能被回收
        //@Getter
        //private Car car ;
        public WeakReferenceNode(K car,V value) {
            super(car);
            this.value = value ;
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
                System.out.println("Object has been collected." );
                break;
            }
        }
        //2. 注意 这里千万不能有car的引用，否则一直car一直不会被回收
    }

    private static void test2(){
        Car car = new Car(22000,"silver") ;
        Person person = new Person("张三","BJS") ;
        WeakReferenceNode<Car,Person> weakCar = new WeakReferenceNode(car, person) ;
        int i = 0 ;
        while (true){
            if(weakCar.get() != null){
                i ++ ;
                System.out.println("Object is alive for " +i+ " loops " + weakCar);
            }else {
                System.out.println("Object has been collected, but value is good : " + weakCar.getValue());
                break;
            }
        }
        //2. 注意 这里千万不能有car的引用，否则一直car一直不会被回收
        //System.out.println(car);
    }

    private void test3(){
        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);
        int i=0;
        while(true){
            //weak reference指向的object就不会被回收了. 因为还有一个strong reference car指向它.
            System.out.println("here is the strong reference 'car' "+car);//use the strong reference in the while loop
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }


}
