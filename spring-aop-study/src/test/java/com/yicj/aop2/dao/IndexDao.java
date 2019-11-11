package com.yicj.aop2.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDao {
    public void query(){
        System.out.println("index");
    }

    public void query2(){
        System.out.println("aaaaaaaaaaaaaa");
    }
}
