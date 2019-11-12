package com.yicj.api.registry.s2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;

/**
 * BeanDefinitionRegistryPostProcessor继承自BeanFactoryPostProcessor，
 * 是一种比较特殊的BeanFactoryPostProcessor。BeanDefinitionRegistryPostProcessor
 * 中定义的postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)方法
 * 可以让我们实现自定义的注册bean定义的逻辑。下面的示例中就新定义了一个名为hello，
 * 类型为Hello的bean定义。
 * 扫描指定包及其子包下面的所有非接口和非抽象类
 */
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
        boolean useDefaultFilters = false;
        String basePackage = "com.yicj.api.entity";
        ClassPathScanningCandidateComponentProvider beanScanner =
                new ClassPathScanningCandidateComponentProvider(useDefaultFilters) ;
        TypeFilter includeFilter = (metadataReader, metadataReaderFactory) ->
                metadataReader.getClassMetadata().isConcrete() ;
        beanScanner.addIncludeFilter(includeFilter);
        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
        for(BeanDefinition beanDefinition : beanDefinitions){
            //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、
            // DefaultBeanNameGenerator等，也可以自己实现。
            String beanName = beanDefinition.getBeanClassName();
            System.out.println();
            System.out.println("=========> beanName : " + beanName);
            registry.registerBeanDefinition(beanName,beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
