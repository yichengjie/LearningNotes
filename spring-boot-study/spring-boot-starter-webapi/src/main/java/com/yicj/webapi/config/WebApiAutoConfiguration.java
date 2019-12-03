package com.yicj.webapi.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

//https://www.jianshu.com/p/4539e312ce87
@Configuration
@EnableSwagger2
//@ComponentScan("com.yicj.springboot.webapi.errors")
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WebApiAutoConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    private TypeResolver typeResolver ;
    @Value("${springfox.api.group}")
    private String apiGroupName ;
    @Value("${springfox.api.title}")
    private String title ;
    @Value("${springfox.api.description}")
    private String description ;
    @Value("${springfox.api.version}")
    private String version ;
    @Value("${springfox.api.termsOfServiceUrl}")
    private String termsOfServiceUrl ;
    @Value("${springfox.api.contactName}")
    private String contactName ;
    @Value("${springfox.api.contactEmail}")
    private String contactEmail ;
    @Value("${springfox.api.contactUrl}")
    private String contactUrl ;
    @Value("${springfox.api.license}")
    private String license ;
    @Value("${springfox.api.licenseUrl}")
    private String licenseUrl ;

    @Bean
    public Docket api(){
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(500)
                .message("服务器内部错误").responseModel(new ModelRef("Error")).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(apiGroupName)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(Date.class,String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                //自定义规则，如果遇到DeferredResult，则把泛型类转成json
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class,
                    typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                    typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(contactName, contactUrl, contactEmail);
        return new ApiInfoBuilder().title(title).description(description).version(version)
                .termsOfServiceUrl(termsOfServiceUrl).contact(contact).license(license)
                .licenseUrl(licenseUrl).build();
    }

}
