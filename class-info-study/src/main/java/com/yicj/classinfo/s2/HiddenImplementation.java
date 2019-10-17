package com.yicj.classinfo.s2;

import com.yicj.classinfo.intefs.A;
import com.yicj.classinfo.intefs.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA() ;
        a.f() ;
        System.out.println(a.getClass().getName());
        //编译错误，C无法被访问
        // if(a instanceof C){
        //    C c = C() ;
        //    c.g() ;
        // }
        //通过反射任然能调用g方法
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");

    }

    static void callHiddenMethod(Object a ,String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a) ;
    }
}
