package com.yicj.classinfo.nil.robot;

import java.util.Arrays;
import java.util.List;

public class SnowRemovelRobot implements Robot {
    private String name ;

    public SnowRemovelRobot(String name){
        this.name = name ;
    }
    @Override
    public String name() {
        return name;
    }
    @Override
    public String mode() {
        return "SnowBot Series 11";
    }
    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can shovel snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can ship ice";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " shipping ice");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name +" can clear the root";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " clearing roof");
                    }
                }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovelRobot("Slusher"));
    }
}
