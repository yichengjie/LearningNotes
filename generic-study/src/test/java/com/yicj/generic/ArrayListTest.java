package com.yicj.generic;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayListTest {
    private Object[] elementData = {"a","b","c","d","e"} ;

    @Test
    public void test1() {
        //测试在遍历的时候使用迭代器移除元素
        List<String> list = new java.util.ArrayList<>();
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
        List<String> list = new java.util.ArrayList<String>();
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

    @Test
    public void test5(){
        //测试位移
        int a = 4 ;
        System.out.println("4 向右移动一位后等于 : " + (a >> 1));
        //测试System.arraycopy
        String [] elementData = {"a","b","c","d","e"} ;
        //元素个数
        int size = elementData.length ;
        //移除元素index
        int index = 2 ;
        //需要移动元素个数
        int numMoved = size - index - 1;
        //从将index+1位置及其后元素复制到原数组的index往后的位置
        System.arraycopy(elementData, index+1, elementData, index,
                numMoved);
        for(String str : elementData){
            System.out.print(str +" ");
        }
        System.out.println();
        System.out.println("elementData length : " + elementData.length);
        elementData[--size] = null ;
    }

    @Test
    public void test6(){
        int modCount = 0 ;
        final Object[] elementData = this.elementData;
        int size = elementData.length ; //5
        int r = 0, w = 0;
        boolean modified = false;
        List<String> c = Arrays.asList("b","d") ;
        try {
            for (; r < size; r++){
                if (c.contains(elementData[r]) == false){
                    elementData[w++] = elementData[r];
                }
            }
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }

            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        for (Object str: elementData){
            System.out.println("index str : " + str);
        }
    }

    @Test
    public void test7(){
        int removeCount = 0;
        int size = elementData.length ;
        final BitSet removeSet = new BitSet(size);
        //移除b->1，d->3
        removeSet.set(1) ; // b
        removeSet.set(3) ; // d
        removeCount = 2;
        final int newSize = size - removeCount; // 5-2 =3
        for (int i=0, j=0; (i < size) && (j < newSize); i++, j++) {
            i = removeSet.nextClearBit(i); // 0、 2、 4
            elementData[j] = elementData[i];
        }

        for (int k=newSize; k < size; k++) {
            elementData[k] = null;  // Let gc do its work
        }
        size = newSize;
        System.out.println("size : " + size);

    }

    @Test
    public void test8(){
        //方法返回第一个位出现或之后指定的起始索引被设置为false的索引。
        BitSet bitset1 = new BitSet(8);
        BitSet bitset2 = new BitSet(8);

        // assign values to bitset1
        bitset1.set(0);
        bitset1.set(1);
        bitset1.set(2);
        bitset1.set(3);
        bitset1.set(4);
        bitset1.set(5);

        // assign values to bitset2
        bitset2.set(2);
        bitset2.set(4);
        bitset2.set(6);
        bitset2.set(8);
        bitset2.set(10);

        // print the sets
        System.out.println("Bitset1:" + bitset1);
        System.out.println("Bitset2:" + bitset2);

        // print the first clear bit of bitset1
        System.out.println("bitset1.nextClearBit(0)" + bitset1.nextClearBit(0));

        // print the first clear bit of bitset2 after index 5
        System.out.println("bitset2.nextClearBit(5)" + bitset2.nextClearBit(5));
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
