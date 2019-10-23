package com.yicj.generic;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    @Test
    public void test1() {
        //测试在遍历的时候使用迭代器移除元素
        List<String> list = new ArrayList<>();
        list.add("beijing");
        list.add("tianjing");
        list.add("shanghai");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            iter.remove();
        }
        System.out.println("size : " + list.size());
    }

    @Test
    public void test2() {
        //测试list.toArray带参数和不带参数时的两种情况
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        //这里能正确运行
        String[] tt = list.toArray(new String[0]);
        //这里会报错 (返回Object[] 数组，转String[]数组报错)
        //ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        String[] tt2 = (String[]) list.toArray();
        //System.out.println(Arrays.asList(tt));
    }

    @Test
    public void test3() {
        //数组内容复制
        String[] original = {"aa", "bb", "cc"};
        //查看数组class
        Class<? extends Object[]> newType = original.getClass();
        System.out.println("original.getClass() : " + newType.getName());
        //复制数组内容
        String[] strings = Arrays.copyOf(original, 3, original.getClass());
        System.out.println(Arrays.asList(strings));
    }

    @Test
    public void test4() {
        //动态创建数组，设置数组内容，获取数组内容，获取数组长度
        String[] aa = new String[2];
        Class<?> componentType = aa.getClass().getComponentType();
        System.out.println("componentType : " + componentType.getName());
        //动态创建数组
        Object array = Array.newInstance(componentType, 5);
        System.out.println("array name: " + array.getClass().getName());
        //设置数组内容
        Array.set(array, 3, "hello world");
        String str = (String) Array.get(array, 3);
        System.out.println("get value : " + str);
        ///获取数组长度
        int length = Array.getLength(array);
        System.out.println("len " + length);
    }




    //修改数组长度
    private Object resizeArray(Object oldArray, int newSize) {
        Class<?> componentType = oldArray.getClass().getComponentType();
        Object newArray = Array.newInstance(componentType, newSize);
        int oldLen = Array.getLength(oldArray);
        int min = Math.min(newSize, oldLen);
        if(min > 0){
            System.arraycopy(oldArray,0,newArray,0,min);
        }
        return newArray;
    }


    private static <T> T[] copyOf(T[] original, int newLength) {
        Class<? extends Object[]> newType = original.getClass();
        System.out.println("original.getClass() : " + newType.getName());
        Class<?> componentType = newType.getComponentType();
        System.out.println("componentType : " + componentType.getName());
        return (T[]) Arrays.copyOf(original, newLength, original.getClass());
    }

}
