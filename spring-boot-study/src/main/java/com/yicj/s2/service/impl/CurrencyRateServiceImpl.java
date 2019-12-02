package com.yicj.s2.service.impl;

import com.yicj.s2.dao.CurrencyRateRepository;
import com.yicj.s2.entity.CurrencyPair;
import com.yicj.s2.entity.ExchangeRate;
import com.yicj.s2.service.CurrencyRateService;
import lombok.Getter;
import lombok.Setter;

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
