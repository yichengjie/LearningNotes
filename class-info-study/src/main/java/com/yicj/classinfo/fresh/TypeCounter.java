package com.yicj.classinfo.fresh;

import java.util.HashMap;
import java.util.Map;

//isAssignableFrom语法的使用
public class TypeCounter  extends HashMap<Class<?> ,Integer> {
    private Class<?> baseType ;
    public TypeCounter(Class<?> baseType){
        this.baseType = baseType ;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass() ;
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + " incorrect type: " +
                    type + ", should be type or subtype of " +
                    baseType) ;
        }
        countClass(type) ;
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type) ;
        int t = 1 ;
        if(quantity != null){
            t = quantity + 1 ;
        }
        put(type,t) ;
        Class<?> superclass = type.getSuperclass();
        //如果父类继承自baseType，则递归进行
        if(superclass != null && baseType.isAssignableFrom(superclass)){
            countClass(superclass) ;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{") ;
        for(Map.Entry<Class<?>,Integer> pair: entrySet()){
            result.append(pair.getKey().getSimpleName()) ;
            result.append("=") ;
            result.append(pair.getValue()) ;
            result.append(", ");
        }
        result.delete(result.length()-2,result.length()) ;
        result.append("}") ;
        return result.toString();
    }
}
