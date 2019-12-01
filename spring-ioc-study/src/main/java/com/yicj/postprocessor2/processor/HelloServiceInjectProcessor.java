package com.yicj.postprocessor2.processor;

import com.yicj.postprocessor2.annotation.RoutingInjected;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class HelloServiceInjectProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext ;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        Class<?> targetCls = bean.getClass();
        Field[] declaredFields = targetCls.getDeclaredFields();
        for(Field field : declaredFields){
            //找到定制目标注解类
            if(field.isAnnotationPresent(RoutingInjected.class)){
                if(!field.getType().isInterface()){
                    throw new BeanCreationException("RoutingInjected field must be declared as an interface:" + field.getName()
                            + " @Class " + targetCls.getName()) ;
                }
                try {
//                    System.out.println("=======> " + bean.getClass().getName() +
//                            ", beanName : " + beanName);
                    this.handleRoutingInjected(field,bean) ;
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    private void handleRoutingInjected(Field field, Object bean)
            throws IllegalAccessException{
        Class<?> type = field.getType();
        Map<String, ?> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if(candidates.size() == 1){
            field.set(bean,candidates.values().iterator().next());
        }else if(candidates.size() == 2){
            String injectVal =
                    field.getAnnotation(RoutingInjected.class).value();
            Object proxy = RoutingBeanProxyFactory.createProxy(injectVal, type, candidates);
            field.set(bean,proxy);
        }else {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }

    }
}
