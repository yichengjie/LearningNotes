package com.yicj.cglib;

public class PersonService {

    public PersonService(){
        System.out.println("PersonService 构造");
    }
    final public Person getPerson(String code){
        System.out.println("PersonService:getPerson>> " + code);
        return null ;
    }
    public void setPerson(){
        System.out.println("PersonService:setPerson()");
    }

}
