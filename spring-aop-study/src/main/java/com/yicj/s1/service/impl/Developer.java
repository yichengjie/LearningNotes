package com.yicj.s1.service.impl;

import com.yicj.s1.service.IDeveloper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Developer implements IDeveloper {
    @Override
    public void developSoftware() {
        log.info("I am happy with programming .");
    }
}
