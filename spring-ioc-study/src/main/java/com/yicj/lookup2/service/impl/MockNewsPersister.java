package com.yicj.lookup2.service.impl;

import com.yicj.lookup2.entity.FXNewsBean;
import com.yicj.lookup2.service.IFXNewsPersister;

public class MockNewsPersister implements IFXNewsPersister {
    public FXNewsBean newsBean ;

    @Override
    public void persistNews() {
        System.out.println("persist bean: " + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return newsBean;
    }
    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }
}
