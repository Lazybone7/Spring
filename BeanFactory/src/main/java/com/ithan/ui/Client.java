package com.ithan.ui;

import com.ithan.dao.IAccountDao;
import com.ithan.factory.BeanFactory;
import com.ithan.service.IAccountService;

public class Client {
    public static void main(String[] args) {
        IAccountService accountService = (IAccountService)BeanFactory.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            System.out.println(accountService);
        }
    }
}
