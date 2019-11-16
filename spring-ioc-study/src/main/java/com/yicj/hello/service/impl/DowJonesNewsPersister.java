package com.yicj.hello.service.impl;

import com.yicj.hello.entity.FXNewsBean;
import com.yicj.hello.service.IFXNewsPersister;

public class DowJonesNewsPersister implements IFXNewsPersister {
    private FXNewsBean newsBean ;
    @Override
    public void persistNews(FXNewsBean newsBean) {
        System.out.println("将新闻"+newsBean.toString()+"保存入库");
    }
}
