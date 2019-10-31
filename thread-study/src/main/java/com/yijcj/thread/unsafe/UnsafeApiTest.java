package com.yijcj.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeApiTest {
    private Unsafe unsafe;

    public void unsafePutGetInt() throws NoSuchFieldException {
        class Student {
            private int age = 5 ;
            public int getAge(){
                return age ;
            }
        }
        Student student = new Student() ;
        System.out.println(student.getAge());
        Field field = student.getClass().getDeclaredField("age") ;
        unsafe.putInt(student,unsafe.objectFieldOffset(field),10);
        System.out.println(student.getAge());
    }
}
