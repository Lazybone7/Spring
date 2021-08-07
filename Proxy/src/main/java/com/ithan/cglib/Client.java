package com.ithan.cglib;

import com.ithan.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        /**
         *  动态代理：
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上，对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *  基于子类的动态代理：
         *      涉及的类：Enhancer
         *      提供者：第三方cglib库
         *      如何创建代理对象：使用Enhancer类中的create方法
         *      创建代理对象的要求：被代理类不能是最终类
         *      create方法参数：
         *          Class：字节码
         *              用于指定被代理对象的字节码
         *          Callback：用于提供增强代码
         *              写的是如何代理，我们一般都是写一个该接口的子接口实现类，MethodInterceptor(方法拦截器);通常情况下是写一个匿名内部类
     *                  此接口的实现类都是谁用谁写
         *
         *
         */
        Producer producerProxy = (Producer)Enhancer.create(Producer.class, new MethodInterceptor() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * @param o 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强方法
                //获取被代理对象的参数
                Float money = (Float) objects[0];
                Object retObject = null;
                if (method.getName() == "saleProduct") {
                    retObject = method.invoke(producer, money * 0.8f);
                }
                return retObject;
            }
        });
        producerProxy.saleProduct(100f);
    }
}
