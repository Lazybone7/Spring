package com.ithan.service.impl;

import com.ithan.dao.IAccountDao;
import com.ithan.domain.Account;
import com.ithan.service.IAccountService;
import com.ithan.util.TransactionManager;

import java.util.List;

/**
 * 业务层实现类
 * 事务控制应该在业务层
 */
public class AccountServiceImpl implements IAccountService{
    private IAccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

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

    @Override
    public void transfer(String source, String target, Float money) {
        //1. 根据名称查询转出账户
        Account accoutSource = accountDao.findAccountByName(source);
        //2. 根据名称查询转入账户
        Account accoutTarget = accountDao.findAccountByName(target);
        //3. 转出账户减钱
        accoutSource.setMoney(accoutSource.getMoney() - money);
        //4. 转入账户加钱
        accoutTarget.setMoney(accoutTarget.getMoney() + money);
        //5. 更新转出账户
        accountDao.updateAccount(accoutSource);
    }
}
