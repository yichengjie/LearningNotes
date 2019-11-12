package com.yicj.api.registry.s1;

import com.yicj.api.entity.Hello;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * BeanDefinitionRegistryPostProcessor继承自BeanFactoryPostProcessor，
 * 是一种比较特殊的BeanFactoryPostProcessor。BeanDefinitionRegistryPostProcessor
 * 中定义的postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)方法
 * 可以让我们实现自定义的注册bean定义的逻辑。下面的示例中就新定义了一个名为hello，
 * 类型为Hello的bean定义。
 */
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        RootBeanDefinition helloBean = new RootBeanDefinition(Hello.class) ;
        //新增Bean定义
        beanDefinitionRegistry.registerBeanDefinition("s1",helloBean);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
