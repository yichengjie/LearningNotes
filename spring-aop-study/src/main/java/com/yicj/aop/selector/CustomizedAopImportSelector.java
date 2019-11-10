package com.yicj.aop.selector;

import com.yicj.aop.processor.RealizedAopBeanPostProcessor;
import com.yicj.aop.processor.RegisterBeanFactoryPostProcessor;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomizedAopImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
            RealizedAopBeanPostProcessor.class.getName(),
            RegisterBeanFactoryPostProcessor.class.getName()
        };
    }
}
