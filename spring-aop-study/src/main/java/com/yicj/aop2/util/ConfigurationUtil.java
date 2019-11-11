package com.yicj.aop2.util;

import com.yicj.aop2.holder.ProxyBeanHolder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//定义数据工具类，具体作用见注释
public class ConfigurationUtil {
    //aop标识注解类
    public static final String AOP_POINTCUT_ANNOTATION = "com.yicj.aop2.annotation.AopJ";
    //前置通知注解类
    public static final String BEFORE = "com.yicj.aop2.annotation.BeforeYicj";
    //后置通知注解类
    public static final String AFTER = "com.yicj.aop2.annotation.AfterYicj";
    //环绕通知注解类
    public static final String AROUND = "com.yicj.aop2.annotation.AroundYicj";
    //存放需代理的全部目标对象类
    public static volatile Map<String, List<ProxyBeanHolder>> classzzProxyBeanHolder =
            new ConcurrentHashMap<>();
}
