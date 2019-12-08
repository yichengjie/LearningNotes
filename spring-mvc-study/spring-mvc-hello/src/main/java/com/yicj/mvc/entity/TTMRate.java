package com.yicj.mvc.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TTMRate implements Serializable {

    private TradeDate tradeDate ;
    private String currencyPair ;
    private BigDecimal value ;

    public TTMRate(TradeDate tradeDate, String currencyPair, BigDecimal value) {
        this.tradeDate = tradeDate;
        this.currencyPair = currencyPair;
        this.value = value;
    }
}
