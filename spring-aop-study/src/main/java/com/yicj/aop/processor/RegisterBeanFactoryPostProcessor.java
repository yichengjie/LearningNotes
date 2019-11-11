package com.yicj.aop.processor;

import com.yicj.aop.holder.ProxyBeanHolder;
import com.yicj.aop.util.ConfigurationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

//定义我们的注册类，用于注册我们的目标对象和通知对象之间的关系，
// 其核心代码如下，首先实现BeanFactoryPostProcessor ，
// 保证其实在对所有的bean完成扫描后，在bean的实例化之前执行，然后再其中按上述思路，
// scan出所有的目标对象，然后建立起目标对象和通知对象的关联关系，然后放入我们的Map中
@Slf4j
public class RegisterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 存放需要代理的相关信息类
     */
    //public static volatile List<ProxyBeanHolder> proxyBeanHolderList = new Vector<>();

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //获取所有的bdName
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition
                    = beanFactory.getBeanDefinition(beanDefinitionName);
            //判断bd是否是一个注解bd
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                //取得bd上的所有注解
                AnnotationMetadata metadata =
                        ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
                Set<String> Annotations = metadata.getAnnotationTypes();
                //循环所有注解，找到aop切面注解类
                for (String annotation : Annotations){
                    if (annotation.equals(ConfigurationUtil.AOP_POINTCUT_ANNOTATION)) {
                        doScan((GenericBeanDefinition) beanDefinition);
                    }
                }
            }
        }
        for( Map.Entry<String, List<ProxyBeanHolder>> entry : ConfigurationUtil.classzzProxyBeanHolder.entrySet()){
            String key = entry.getKey();
            List<ProxyBeanHolder> value = entry.getValue() ;
            log.info("key : " + key +" , value : " + value);
        }
    }

    //扫描所有注解方法
    private void doScan(GenericBeanDefinition beanDefinition){
        try {
            String className = beanDefinition.getBeanClassName();
            //System.out.println("============> className :  " + className);
            Class<?> beanDefinitionClazz = Class.forName(className);
            Method[] methods = beanDefinitionClazz.getMethods();
            for (Method method : methods){
                Annotation[] annotations = method.getAnnotations();
                for(Annotation annotation : annotations) {
                    String annotationName = annotation.annotationType().getName();
                    if(annotationName.equals(ConfigurationUtil.BEFORE) ||
                            annotationName.equals(ConfigurationUtil.AFTER)||
                            annotationName.equals(ConfigurationUtil.AROUND)){
                        doScan(className, method, annotation);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //扫描出所有被代理的类
    private void doScan(String className, Method method, Annotation annotation){
        ProxyBeanHolder proxyBeanHolder = new ProxyBeanHolder();
        proxyBeanHolder.setClassName(className);
        proxyBeanHolder.setMethodName(method.getName());
        proxyBeanHolder.setAnnotationName(annotation.annotationType().getName());
        log.info("===========> className : " + className +", methodName : " +
                method.getName() + ", annotationName : " + annotation.annotationType().getName() );
        //获取注解上的所有方法
        Method[] annotationMethods = annotation.annotationType().getDeclaredMethods();
        String packagePath = null;
        for (Method annotationMethod : annotationMethods) {
            if (annotationMethod.getName().equals("value")){
                try {
                    packagePath = (String) annotationMethod.invoke(annotation, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!packagePath.isEmpty()){
            String rootPath = this.getClass().getResource("/").getPath();
            String targetPackagePath = rootPath +
                    packagePath.replace(".","/");
            File file = new File(targetPackagePath);
            File[] fileList = file.listFiles();
            List<ProxyBeanHolder> lroxyBeanHolderList = null;
            for (File tmpFile : fileList) {
                if (tmpFile.isFile()) {//判断是否为文件
                    String targetClass = packagePath+"."+tmpFile.getName()
                            .replace(".class","");
                    try {
                        lroxyBeanHolderList = ConfigurationUtil
                                .classzzProxyBeanHolder.get(targetClass);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    if (lroxyBeanHolderList == null){
                        lroxyBeanHolderList = new Vector<>();
                    }
                    lroxyBeanHolderList.add(proxyBeanHolder);
                    ConfigurationUtil.classzzProxyBeanHolder
                            .put(targetClass,lroxyBeanHolderList);
                }
            }

        }
    }
}
