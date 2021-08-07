package com.ithan.proxy;

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
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *      如何创建代理对象：使用Proxy类中的newProxyInstance方法
         *      创建代理对象的要求：被代理类最少实现一个接口，如果没有则不能使用
         *      newProxyInstance方法参数：
         *          ClassLoader：类加载器
         *              用于加载代理对象的字节码。写的是和被代理对象相同的类加载器
         *          Class[]：字节码数组
         *              用于让代理对象与被代理对象实现相同的方法.固定写法
         *          InvocationHandler：用于提供增强代码
         *              写的是如何代理，我们一般都是写一个该接口的实现类。通常情况下是写一个匿名内部类
     *                  此接口的实现类都是谁用谁写
         *
         */
        IProducer producer1 = (IProducer) Proxy.newProxyInstance(Producer.class.getClassLoader(), Producer.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return  和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强方法
                        //获取被代理对象的参数
                        Float money = (Float) args[0];
                        Object retObject = null;
                        if (method.getName() == "saleProduct"){
                            retObject = method.invoke(producer, money*0.8f);
                        }
                        return retObject;
                    }
                });
        producer1.saleProduct(12f);
    }
}
