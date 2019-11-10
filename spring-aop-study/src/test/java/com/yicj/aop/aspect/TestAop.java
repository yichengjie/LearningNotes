package com.yicj.aop.aspect;

import com.yicj.aop.annotation.AfterYicj;
import com.yicj.aop.annotation.AopJ;
import com.yicj.aop.annotation.AroundYicj;
import com.yicj.aop.annotation.BeforeYicj;
import org.springframework.stereotype.Component;

@AopJ
@Component
public class TestAop {
    @BeforeYicj("com.yicj.aop.dao")
    public void testBefore(){
        System.out.println("before   ------------------  测试成功！");
    }

    @AfterYicj("com.yicj.aop.dao")
    public void testAfter(){
        System.out.println("after   ------------------  测试成功！");
    }

    @AroundYicj("com.yicj.aop.dao")
    public void testAround(){
        System.out.println("around   ------------------  测试成功！");
    }
}
