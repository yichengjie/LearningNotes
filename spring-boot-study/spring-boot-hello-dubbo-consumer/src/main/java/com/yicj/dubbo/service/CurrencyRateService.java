package com.yicj.dubbo.service;


import com.yicj.dubbo.entity.CurrencyPair;
import com.yicj.dubbo.entity.ExchangeRate;

public interface CurrencyRateService {
    ExchangeRate quote(CurrencyPair currencyPair) ;
}
