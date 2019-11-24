package com.yicj.api.import1.s2;

import com.yicj.api.import1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

//通过ImportBeanDefinitionRegistrar将类注入到Spring IOC容器
//通过ImportBeanDefinitionRegistrar的方式我们可以对类进行个性化的定制，
// 比如对需要传入的参数进行修改，也可以通过ImportBeanDefinitionRegistrar
// 注入一批相似的类。有BeanDefinitionRegistry对象也有可以控制
// Spring IOC容器里Bean的定义，想做些什么也就方便很多了。
public class UserServiceBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder =
                BeanDefinitionBuilder.rootBeanDefinition(UserServiceImpl.class) ;
        registry.registerBeanDefinition("userService",builder.getBeanDefinition());
    }
}
