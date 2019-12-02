package com.yicj.jmx;

public class User implements UserMBean {
    private String name;
    private String passwd;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public void SetPasswd(String pwd) {
        this.passwd = pwd;
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
