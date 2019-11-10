package com.yicj.aop.holder;

import lombok.Data;

//定义holder，用于描述通知信息
@Data
public class ProxyBeanHolder {
    //通知类名称
    private volatile String className;
    //通知方法名称
    private volatile String methodName;
    //注解类名称
    private volatile String annotationName;
}
