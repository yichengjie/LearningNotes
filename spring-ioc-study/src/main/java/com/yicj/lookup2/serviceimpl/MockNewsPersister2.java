package com.yicj.lookup2.serviceimpl;

import com.yicj.common.entity.FXNewsBean;
import com.yicj.common.service.IFXNewsPersister;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MockNewsPersister2 implements IFXNewsPersister , BeanFactoryAware {
    private BeanFactory beanFactory ;
    //public FXNewsBean newsBean ;

    @Override
    public void persistNews() {
        System.out.println("persist bean: " + getNewsBean());
    }

    //即使没有方式注入，只要在实现getNewsBean()方法的时候，
    // 能保证每次调用BeanFactory的getBean("newsBean")，就同样可以每次都取得新的FXNewsBean对象实例.
    public FXNewsBean getNewsBean() {
        return (FXNewsBean)this.beanFactory.getBean("newsBean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory ;
    }
}
