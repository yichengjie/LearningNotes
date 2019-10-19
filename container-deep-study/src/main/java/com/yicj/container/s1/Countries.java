package com.yicj.container.s1;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Countries {

    public static final String [][] DATA = {
        //Africa
        {"ALGERIA","Algiers"},{"ANGOLA","Luanda"},
        {"BENIN","Proto-Nove"},{"BOTSWANA","Gaberone"}
    } ;

    private static class FlyweightMap
            extends AbstractMap<String,String>{
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return null;
        }

        private static class Entry implements Map.Entry<String,String>{
            int index ;
            Entry(int index){
                this.index = index ;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj) ;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
               throw new UnsupportedOperationException();
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode() ;
            }
        }

    }
}
