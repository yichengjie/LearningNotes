package com.yicj.classinfo.pets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData {
    public static <K,V> Map<K,V> map(List<K> list ,V defaultValue){
        Map<K,V> retMap = new HashMap<K, V>() ;
        for(K key : list){
            retMap.put(key,defaultValue) ;
        }
        return retMap ;
    }
}
