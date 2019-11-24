package com.yicj.api.import1.s1;

import com.yicj.api.import1.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
@Import({UserServiceImpl.class})
public class Config1 {
}
