package com.yicj.s2.service;

import com.yicj.s2.entity.CurrencyPair;
import com.yicj.s2.entity.ExchangeRate;

public interface CurrencyRateService {
    ExchangeRate quote(CurrencyPair currencyPair) ;
}
