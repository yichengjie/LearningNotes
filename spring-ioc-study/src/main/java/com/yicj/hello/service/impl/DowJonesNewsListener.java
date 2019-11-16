package com.yicj.hello.service.impl;

import com.yicj.hello.entity.FXNewsBean;
import com.yicj.hello.service.IFXNewsListener;
import java.util.HashMap;
import java.util.Map;

public class DowJonesNewsListener implements IFXNewsListener {
    private Map<String,String> map = new HashMap<>() ;

    {
        map.put("001","测试新闻001") ;
        map.put("002","测试新闻002") ;
        map.put("003","测试新闻003") ;
    }

    @Override
    public String[] getAvailableNewsIds() {
        return new String[]{"001","002","003"};
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return new FXNewsBean(newsId,map.get(newsId));
    }

}
