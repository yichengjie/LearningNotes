package com.yicj.generic.s3;

import com.yicj.generic.common.Generator;

public class RandomGenerator {
    static class String implements Generator<String>{
        java.lang.String [] tmp = new java.lang.String []{"a","b"}  ;
        private int len  ;
        public String(int len){
            this.len = len ;
        }
        @Override
        public String next() {
            return null;
        }
    }
}
