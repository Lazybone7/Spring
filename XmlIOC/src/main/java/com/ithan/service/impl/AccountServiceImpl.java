package com.ithan.service.impl;

import com.ithan.dao.IAccountDao;
import com.ithan.domain.Account;
import com.ithan.service.IAccountService;

import java.util.List;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService{
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByid(Integer id) {
        return accountDao.findAccountByid(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
