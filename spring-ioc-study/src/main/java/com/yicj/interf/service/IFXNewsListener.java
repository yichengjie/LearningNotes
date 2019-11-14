package com.yicj.interf.service;

import com.yicj.interf.callback.FXNewsListenerCallback;
import com.yicj.interf.entity.FXNewsBean;

public interface IFXNewsListener  {
    String[] getAvailableNewsIds();
    FXNewsBean getNewsByPK(String newsId);
    void postProcessIfNecessary(String newsId);
}
