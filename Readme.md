# AOP概述

##  1. 什么是AOP

**AOP:** Aspect Oriented Programming；面向切面编程

![image-20210807124145132](E:\LearnNote\SSM\Spring\Readme.assets\image-20210807124145132.png)

```
简单来说就是把程序重复的代码抽取出来，在需要执行的时候，使用动态代理的
技术，在不修改源码的基础上，对我们已有的方法增强
```

## 2. AOP的作用与优势

```
作用：
	在程序运行期间，不修改源码对已有方法进行增强
优势：
	减少重复代码；提高开发效率；维护方便
```

## 3.AOP的实现方式

```
使用动态代理技术
```

# Spring中的AOP

## AOP相关术语

```
JoinPoint 连接点：
		所谓连接点是指那些被拦截到的点。在spring中，这些点指的是方法，因为
		Spring中只支持方法类型的连接点。
Pointcut	切入点：
		所谓切入点是指我们要对哪些JoinPoint进行拦截定义。简单来说就是被拦截
		的方法
Advice(通知/增强)
		所谓通知是指拦截到JoinPoint之后所要做的事情就是通知。
		通知的类型：前置通知，后置通知，异常通知，最终通知，环绕通知
Introduction(引介)
		引介是一种特殊的通知在不修改类代码的前提下，Introduction可以在
		运行期为类动态地添加一些方法和属性。
Target（目标对象）
		代理的目标对象
Waving（织入）
		是指把增强方法应用到目标对象来创建新的代理对象的过程
		spring采用动态代理织入，而AspectJ采用编译器织入和类装载期织入
Proxy（代理）
		一个类被AOP织入增强后，就产生一个结果代理类
Aspect（切面）
		是指切入点和通知的结合
```

![image-20210807131708163](E:\LearnNote\SSM\Spring\Readme.assets\image-20210807131708163.png)

## 四种常用通知类型

**前置通知：** 在切入点方法执行之前执行

```xml
<aop:before method="" pointcut=""></aop:before>
```

**后置通知：** 在切入点方法正常执行之后执行；它和异常通知永远只能执行一个

```xml
<aop:after-returning method="" pointcut=""></aop:before>
```

**异常通知：**在切入点方法执行产生异常后执行

```xml
<aop:after-throwing method="" pointcut=""></aop:before>
```

**最终通知：**无论切入点方法是否正常执行他都会在其后面执行

```xml
<aop:after method="" pointcut=""></aop:before>
```

**环绕通知：**当配置了环绕通知后，切入点方法没有执行而通知方法执行了。原因是没有明确的切入点方法调用。通过Spring框架为我们提供的**ProceedingJoinPoint**接口，调用其中的**proceed()**方法。此方法就相当于明确调用切入点方法。该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用

```xml
<aop:around method="aroundLog" pointcut-ref="pt1"></aop:around>
```



```java
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
```



## 配置切入点表达式

```xml
<aop:pointcut id="pt1" expression="execution(* com.ithan.service.impl.*.*(..))"></aop:pointcut>
```

1.  **id属性：**用于指定表达式的唯一标志
2.  **expression属性：**用于指定表达式内容
3.  此表达式可以写在切面内部，仅供该切面使用；也可写在切面外部，供所有切面使用（必须写在切面之前）。

