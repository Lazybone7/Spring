package com.ithan.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类,它里面提供了公共的代码
 */
public class Logger {
    /**
     * 打印日志：计划在切入点方法执行之前执行
     */
    public void beforeLog(){
        System.out.println("开始记录日志。。。");
    }

    public void afterLog(){
        System.out.println("日志记录完毕。。。");
    }

    public void afterThrowingLog(){
        System.out.println("日志异常通知。。。");
    }

    public void finalLog(){
        System.out.println("日志最终通知。。。");
    }

    /**
     * 环绕通知
     */
    public Object aroundLog(ProceedingJoinPoint pjp){
        Object retValue = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("aroundLog方法执行。。前置");
            retValue = pjp.proceed(args);
            System.out.println("aroundLog方法执行。。后置");
            return retValue;
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("aroundLog方法执行。。异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("aroundLog方法执行。。最终 ");
        }
    }

}
