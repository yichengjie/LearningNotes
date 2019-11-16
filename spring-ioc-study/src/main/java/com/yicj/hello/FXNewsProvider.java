package com.yicj.hello;

import com.yicj.common.utils.ArrayUtils;
import com.yicj.hello.entity.FXNewsBean;
import com.yicj.hello.service.IFXNewsPersister;
import com.yicj.hello.service.IFXNewsListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FXNewsProvider {
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
        }
    }
}
