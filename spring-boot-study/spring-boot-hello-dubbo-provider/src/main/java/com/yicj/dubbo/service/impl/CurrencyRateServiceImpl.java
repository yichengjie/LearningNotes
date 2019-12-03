package com.yicj.dubbo.service.impl;


import com.yicj.dubbo.dao.CurrencyRateRepository;
import com.yicj.dubbo.entity.CurrencyPair;
import com.yicj.dubbo.entity.ExchangeRate;
import com.yicj.dubbo.service.CurrencyRateService;

public class CurrencyRateServiceImpl implements CurrencyRateService {

    private CurrencyRateRepository rateRepository ;

    @Override
    public ExchangeRate quote(CurrencyPair currencyPair) {
        return rateRepository.get(currencyPair);
    }

    public CurrencyRateRepository getRateRepository() {
        return rateRepository;
    }
    public void setRateRepository(CurrencyRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }
}
