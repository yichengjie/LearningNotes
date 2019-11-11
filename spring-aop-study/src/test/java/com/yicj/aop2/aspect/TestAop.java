package com.yicj.aop2.aspect;

import com.yicj.aop2.annotation.AfterYicj;
import com.yicj.aop2.annotation.AopJ;
import com.yicj.aop2.annotation.AroundYicj;
import com.yicj.aop2.annotation.BeforeYicj;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@AopJ
@Component
public class TestAop {
    @BeforeYicj("com.yicj.aop.dao")
    public void testBefore(Method method,Object [] args,Object target){
        System.out.println("before   ------------------  测试成功！");
    }

    @AfterYicj("com.yicj.aop")
    public void testAfter(Object retVal,Method method, Object [] args, Object target){
        System.out.println("after   ------------------  测试成功！");
    }

    @AroundYicj("com.yicj.aop.dao")
    public void testAround(){
        System.out.println("around   ------------------  测试成功！");
    }
}
