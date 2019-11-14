package com.yicj.interf.service.impl;

import com.yicj.interf.entity.FXNewsBean;
import com.yicj.interf.service.IFXNewsPersister;

public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews(FXNewsBean newsBean) {
        System.out.println("将新闻"+newsBean.toString()+"保存入库");
    }
}
