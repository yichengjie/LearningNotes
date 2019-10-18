package com.yicj.generic.s2;

class Employee{}

class ClassAsFactory<T> {
    T x ;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance() ;
        } catch (Exception e) {
            throw  new RuntimeException(e) ;
        }
    }
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class) ;
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> f1 = new ClassAsFactory<>(Integer.class) ;
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }
        /**
         * ClassAsFactory<Employee> succeeded
         * ClassAsFactory<Integer> failed
         */
    }
}
