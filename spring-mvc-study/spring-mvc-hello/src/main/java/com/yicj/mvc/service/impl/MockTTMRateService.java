package com.yicj.mvc.service.impl;

import com.yicj.mvc.entity.TTMRate;
import com.yicj.mvc.entity.TradeDate;
import com.yicj.mvc.service.ITTMRateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class MockTTMRateService implements ITTMRateService{

    @Override
    public List<TTMRate> getTTMRatesToday() {
        TradeDate tradeDate1 = TradeDate.valueOf("20080302") ;
        TTMRate USD_JPY = new TTMRate(tradeDate1, "USD/JPY", new BigDecimal("121.53")) ;
        TTMRate EUR_USD = new TTMRate(tradeDate1,"EUR/USD",new BigDecimal("1.8950")) ;
        List<TTMRate> rateList = new ArrayList<TTMRate>() ;
        rateList.add(USD_JPY) ;
        rateList.add(EUR_USD) ;
        return rateList;
    }
}

