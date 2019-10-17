package com.yicj.classinfo.nil.robot;

import com.yicj.classinfo.nil.common.Null;

import java.util.List;

public interface Robot {
    String name() ;
    String mode() ;
    List<Operation> operations() ;
    class Test{
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name : " + r.name());
            System.out.println("Robot model: " + r.mode());
            for(Operation operation : r.operations()){
                operation.command();
            }
            System.out.println("==========================================");
        }
    }
}
