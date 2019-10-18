package com.yicj.generic.s2;

import java.lang.reflect.Array;


//类型标记Class<T> 被传递到构造器中，以便从擦除中恢复,
// 使得我们可以创建需要的实际类型的数组,
//一旦我们获得了实际类型，就可以返回它，并获得想要的结果，
//就像在main看到的那样，该数组的运行时类型是确切类型T[]
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index){
        return array[index] ;
    }
    public T[] rep(){
        return array ;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(Integer.class,10) ;
        // This now works
        Integer [] ia = gai.rep() ;
    }

}
