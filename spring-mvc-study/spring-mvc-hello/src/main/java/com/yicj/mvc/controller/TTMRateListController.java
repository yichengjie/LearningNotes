package com.yicj.mvc.controller;

import com.yicj.mvc.entity.TTMRate;
import com.yicj.mvc.service.ITTMRateService;
import lombok.Getter;
import lombok.Setter;
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
        List<TTMRate> list = getTtmRateService().getTTMRatesToday() ;
        ModelAndView mav = new ModelAndView(getViewName()) ;
        mav.addObject("ttmRates",list) ;
        return mav;
    }
}
