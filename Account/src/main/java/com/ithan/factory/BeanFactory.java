package com.ithan.factory;

import com.ithan.domain.Account;
import com.ithan.service.IAccountService;
import com.ithan.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 用于创建Service代理对象的工厂
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object retValue = null;
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            retValue = method.invoke(accountService,args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return retValue;
                        } catch (Exception e) {
                            //回滚事务
                            transactionManager.rollBack();
                            throw new RuntimeException(e);
                        } finally {
                            //关闭资源
                            transactionManager.close();
                        }
                    }
                });
    }
}
