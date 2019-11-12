package com.yicj.beandefinition.s2;

import com.yicj.api.registry.s2.SpringConfiguration;
import com.yicj.api.entity.Hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class CustomBeanDefinitionRegistryTest {
    @Autowired
    private Hello hello ;

    @Test
    public void test(){
        hello.hello();
    }

}
