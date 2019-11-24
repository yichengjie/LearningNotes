package com.yicj.api.import1.s3;

import com.yicj.api.import1.service.impl.UserServiceImpl;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class UserServiceImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String,Object> map = importingClassMetadata.getAnnotationAttributes(
                EnableUserService.class.getName(),true) ;
        for(Map.Entry<String,Object> entry: map.entrySet()){
            System.out.println("key is : " + entry.getKey() +" , value is : " + entry.getValue());
        }
        return new String[]{UserServiceImpl.class.getName()};
    }
}
