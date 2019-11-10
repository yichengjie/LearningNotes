package com.yicj.cglib2;

public class Dao {

    //如果想要在构造函数中调用update()方法时，不拦截的话，
    // Enhancer中有一个setInterceptDuringConstruction(
    // boolean interceptDuringConstruction)方法设置为false即可，
    // 默认为true，即构造函数中调用方法也是会拦截的。那么测试方法这么写：
    public Dao(){
        this.update();
    }

    public void update() {
        System.out.println("PeopleDao.update()");
    }

    public void select() {
        System.out.println("PeopleDao.select()");
    }
}
