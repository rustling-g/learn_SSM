package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，里面提供了公共的代码
 * @author gg
 * @create 2020-11-24 下午6:38
 */
@Component("logger")
@Aspect //表示当前类是切面类
//使用注解配置aop时，建议用环绕通知
public class Logger {

    /*
    四种通知对应于
    try{
        前置通知
        *待扩展方法*
        后置通知
    }catch{
        异常通知(和后置通知只能执行其中一个)
    }finally{
        最终通知
    }
     */

    @Pointcut("execution(* com.service.impl.*.*(..))")
    public void pt1(){

    }

    //前置通知
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知beforePrintLog开始记录日志");
    }

    //后置通知
    @AfterReturning("pt1()")
    public void afterReturnPrintLog(){
        System.out.println("后置通知afterReturnPrintLog开始记录日志");
    }

    //异常通知
    @AfterThrowing("pt1()")
    public void afterThrowPrintLog(){
        System.out.println("异常通知afterThrowPrintLog开始记录日志");
    }

    //最终通知
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知afterPrintLog开始记录日志");
    }

    //环绕通知
    //Spring中的环绕通知是Spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            System.out.println("环绕通知aroundPrintLog开始记录日志。。前");
            Object[] args = pjp.getArgs();     //得到方法运行所需的参数
            rtValue = pjp.proceed(args);       //明确调用业务层方法
            System.out.println("环绕通知aroundPrintLog开始记录日志。。后");
        }catch (Throwable t){
            System.out.println("环绕通知aroundPrintLog开始记录日志。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知aroundPrintLog开始记录日志。。最终");
        }
        return rtValue;
    }
}
