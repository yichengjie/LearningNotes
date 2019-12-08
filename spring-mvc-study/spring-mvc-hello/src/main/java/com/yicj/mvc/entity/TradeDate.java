package com.yicj.mvc.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeDate {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMDD") ;
    private Date date ;

    public TradeDate(Date date){
        this.date = date ;
    }

    public static TradeDate valueOf(String s) {
        try {
            Date parse = format.parse(s);
            return new TradeDate(parse) ;
        }catch (ParseException e){
            return null ;
        }
    }
}
