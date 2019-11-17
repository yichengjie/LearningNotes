package com.yicj.lookup2.serviceimpl;

import com.yicj.common.entity.FXNewsBean;
import com.yicj.common.service.IFXNewsPersister;

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
