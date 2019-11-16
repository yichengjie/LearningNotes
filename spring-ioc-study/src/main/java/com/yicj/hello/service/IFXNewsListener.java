package com.yicj.hello.service;


import com.yicj.hello.entity.FXNewsBean;

public interface IFXNewsListener {
    String[] getAvailableNewsIds();
    FXNewsBean getNewsByPK(String newsId);
}
