package com.yicj.interf;


import com.yicj.interf.callback.FXNewsListenerCallback;
import com.yicj.interf.callback.FXNewsPersisterCallback;
import com.yicj.interf.entity.FXNewsBean;
import com.yicj.interf.service.IFXNewsListener;
import com.yicj.interf.service.IFXNewsPersister;
import com.yicj.interf.utils.ArrayUtils;

public class FXNewProvider implements  FXNewsListenerCallback , FXNewsPersisterCallback {

    private IFXNewsListener newsListener ;
    private IFXNewsPersister newsPersister ;

    public void getAndPersistNews(){
        String [] newsIds = this.newsListener.getAvailableNewsIds() ;
        if(ArrayUtils.isEmpty(newsIds)){
            return;
        }
        for(String newsId : newsIds){
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean) ;
            newsListener.postProcessIfNecessary(newsId) ;
        }
    }

    @Override
    public void injectNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener ;
    }

    @Override
    public void injectNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister ;
    }
}
