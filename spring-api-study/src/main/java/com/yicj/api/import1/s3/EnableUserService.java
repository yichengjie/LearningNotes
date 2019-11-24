package com.yicj.api.import1.s3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(UserServiceImportSelect.class)
public @interface EnableUserService {
    String name () ;
}
