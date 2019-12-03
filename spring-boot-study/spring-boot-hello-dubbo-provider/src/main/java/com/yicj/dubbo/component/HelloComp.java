package com.yicj.dubbo.component;

import com.yicj.dubbo.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloComp implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        CurrencyRateService bean = context.getBean(CurrencyRateService.class);
        log.info("===========> " + bean);
    }
}
