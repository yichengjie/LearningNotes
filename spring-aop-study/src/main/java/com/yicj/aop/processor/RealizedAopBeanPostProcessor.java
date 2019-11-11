package com.yicj.aop.processor;

import com.yicj.aop.interceptor.CustomizedProxyInterceptor;
import com.yicj.aop.util.ConfigurationUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

// 我们可以利用BeanPostProcessor，在bean实例化之后，在放入容器之前，
// 进行一个条件过滤，如果当前对象是我们的目标对象（即在我们定义好的Map中），
// 则对对象进行代理，将目标对象替换成代理对象返回即可
public class RealizedAopBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(
            Object bean, String beanName) throws BeansException {
        String targetClass = bean.getClass().getName();
        Object object = bean;
        if (ConfigurationUtil.classzzProxyBeanHolder.containsKey(targetClass)){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(object.getClass());
            enhancer.setCallback(new CustomizedProxyInterceptor(
                    ConfigurationUtil.classzzProxyBeanHolder.get(targetClass)));
            object =  enhancer.create();
        }
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
