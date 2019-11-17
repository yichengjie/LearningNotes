package com.yicj.postprocessor;

import com.yicj.common.entity.DateFoo;
import com.yicj.postprocessor.component.DatePropertyEditor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.beans.PropertyEditor;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class CustomEditorConfiguratorTest {
    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("com/yicj/postprocessor/beans.xml")) ;
        //
        CustomEditorConfigurer ceConfigurer = new CustomEditorConfigurer() ;
        Map customerEditors = new HashMap() ;
        customerEditors.put(java.util.Date.class,DatePropertyEditor.class) ;
        ceConfigurer.setCustomEditors(customerEditors);
        //
        ceConfigurer.postProcessBeanFactory(beanFactory);
        DateFoo foo = (DateFoo)beanFactory.getBean("dateFoo") ;
        System.out.println(foo);
    }
}
