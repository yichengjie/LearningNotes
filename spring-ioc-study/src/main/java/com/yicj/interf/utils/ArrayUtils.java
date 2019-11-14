package com.yicj.interf.utils;

public class ArrayUtils {
    public static boolean isEmpty(String[] newsIds) {
        if(newsIds == null || newsIds.length == 0){
            return true ;
        }
        return false ;
    }
}
