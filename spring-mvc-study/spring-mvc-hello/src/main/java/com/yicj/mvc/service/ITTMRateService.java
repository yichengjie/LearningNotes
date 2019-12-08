package com.yicj.mvc.service;

import com.yicj.mvc.entity.TTMRate;
import com.yicj.mvc.entity.TradeDate;

import java.util.List;

public interface ITTMRateService {

    List<TTMRate> getTTMRatesToday(TradeDate tradeDate) ;
}
