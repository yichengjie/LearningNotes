package com.yicj.classinfo.s2;

import com.yicj.classinfo.intefs.A;
import com.yicj.classinfo.intefs.InnerA;

public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA() ;
        a.f();
        System.out.println(a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}
