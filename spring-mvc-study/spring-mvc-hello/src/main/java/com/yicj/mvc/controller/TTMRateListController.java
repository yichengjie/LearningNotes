package com.yicj.mvc.controller;

import com.yicj.mvc.entity.TTMRate;
import com.yicj.mvc.entity.TradeDate;
import com.yicj.mvc.service.ITTMRateService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TTMRateListController extends AbstractController {
    @Getter
    @Setter
    private ITTMRateService ttmRateService ;
    @Getter
    @Setter
    private String viewName ;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String tradeDateStr = ServletRequestUtils.getStringParameter(request, "tradeDate");
        if(tradeDateStr == null){
            tradeDateStr = "20080302" ;
        }
        TradeDate tradeDate = TradeDate.valueOf(tradeDateStr) ;
        List<TTMRate> list = getTtmRateService().getTTMRatesToday(tradeDate) ;
        ModelAndView mav = new ModelAndView(getViewName()) ;
        mav.addObject("ttmRates",list) ;
        return mav;
    }
}
