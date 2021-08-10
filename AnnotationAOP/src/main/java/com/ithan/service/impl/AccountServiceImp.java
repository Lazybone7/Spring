package com.ithan.service.impl;

import com.ithan.service.IAccountService;
import org.springframework.stereotype.Service;


/**
 * 账户业务层的实现类
 */
@Service("accountService")
public class AccountServiceImp implements IAccountService{
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了账户");
        return 0;
    }
}
