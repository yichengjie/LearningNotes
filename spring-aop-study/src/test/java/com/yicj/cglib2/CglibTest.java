package com.yicj.cglib2;

import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class CglibTest {


    @Test
    public void testCglib(){
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);
        Dao dao = (Dao)enhancer.create();
        dao.update();
        System.out.println("---------------------");
        dao.select();
    }

    @Test
    public void testCglib2() {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        Callback[] callbacks = {daoProxy, daoAnotherProxy, NoOp.INSTANCE};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new DaoFilter());
        //enhancer.setInterceptDuringConstruction(false);
        Dao dao = (Dao)enhancer.create();
        dao.update();
        System.out.println("======================");
        dao.select();
    }

}
