package com.yicj.mvc.service.impl;

import com.yicj.mvc.entity.TTMRate;
import com.yicj.mvc.entity.TradeDate;
import com.yicj.mvc.service.ITTMRateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockTTMRateService implements ITTMRateService{
    private Map<TradeDate,List<TTMRate>> mockData = new HashMap<TradeDate, List<TTMRate>>() ;

    public MockTTMRateService(){
        TradeDate tradeDate = TradeDate.valueOf("20080302") ;
        TTMRate USD_JPY = new TTMRate(tradeDate, "USD/JPY", new BigDecimal("121.53")) ;
        TTMRate EUR_USD = new TTMRate(tradeDate,"EUR/USD",new BigDecimal("1.8950")) ;
        List<TTMRate> rateList = new ArrayList<TTMRate>() ;
        rateList.add(USD_JPY) ;
        rateList.add(EUR_USD) ;
        mockData.put(tradeDate,rateList) ;
    }

    @Override
    public List<TTMRate> getTTMRatesToday(TradeDate tradeDate) {
        List<TTMRate> ttmRates = mockData.get(tradeDate) ;
        if(ttmRates == null){
            return new ArrayList<TTMRate>() ;
        }
        return ttmRates;
    }
}

