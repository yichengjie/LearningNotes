package com.yicj.webapi.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@Configuration
@EnableSwagger2
//@ComponentScan("com.yicj.springboot.webapi.errors")
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WebApiAutoConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    private TypeResolver typeResolver ;
    @Value("${springfox.api.group:[your api group name]}")
    private String apiGroupName ;
    private String title ;
    private String desc ;
    private String version ;
    private String termsOfServiceUrl ;
    private String contact ;
    private String license ;
    private String licenseUrl ;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(apiGroupName)
                .apiInfo(new ApiInfo(title,desc,version,termsOfServiceUrl,contact,license,licenseUrl))
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(Date.class,String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                //.alternateTypeRules()
                ;
    }


}
