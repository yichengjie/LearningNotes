package com.yicj.s3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

//execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
// 其中方法的返回类型、方法名、参数类型的匹配模式是必须指定的，其他部分的匹配模式可以省略

//modifiers-pattern：指定方法的修饰符，支持通配符，该部分可以省略
//ret-type-pattern：指定方法的返回值类型，支持通配符，可以使用"*"通配符来匹配所有的返回值类型。
//declaring-type-pattern：指定方法所属的类，支持通配符，该部分可以省略。
//name-pattern：指定匹配指定的方法名，支持通配符，可以使用"*"通配符来匹配所有方法。
//param-pattern：指定方法声明中的形参列表，支持两个通配符，即"*"和".."，其中“*”代表一个任意类型的参数，而“..”代表零个或多个任意类型的参数。例如，()匹配一个不接受任何参数的方法，而(..)匹配一个接受任意数量参数的方法，(*)匹配了一个接受一个任何类型的参数的方法，(*,String)匹配了一个接受两个参数的方法，其中第一个参数是任意类型，第二个参数必须是String类型。
//throws-pattern：指定方法声明抛出的异常，支持通配符，该部分可以省略.
//个人翻译
//modifiers-pattern : 访问权限           ==> public 、private 等
//ret-type-pattern: 返回值类型           ==> void 、String、等
//declaring-type-pattern:指定方法所属的类 ==> com.yicj.s3.busi.Foo
//name-pattern : 方法名称                ==> method1()
//param-pattern: 参数类型                ==> String

//(1)* 可以用在任何部分的匹配模式中，可以匹配相邻的多个字符，即一个Word
//(2)..通配符可以在declaring-type-pattern规定的位置，则可以指定多个层次的类型申明,eg:
//execution (void cn.spring21.*.doSomething(*))，只能指定到cn.spring21这一层下所有类型
//execution (void cn.spring21..*.doSomething(*))可以匹配cn.spring21包下所有类型，
// 以及cn.spring21下层包下声明的所有类型
//(2)..用于方法参数表示方法参数可以有0到多个参数，参数类型不限,eg:execution(void *.doSomething(..))

@Aspect
@Slf4j
public class PerformanceTraceAspect {

    @Pointcut("execution(public void method1()) || " +
            "execution(public void method2())")
    public void pointcutName() {}

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint)throws Throwable {
        StopWatch watch = new StopWatch() ;
        try {
            watch.start();
            return joinPoint.proceed() ;
        }finally {
            watch.stop();
            log.info("PT in method[" +
                    joinPoint.getSignature().getName() +"]>>>> "
                    + watch.toString());
        }
    }
}
