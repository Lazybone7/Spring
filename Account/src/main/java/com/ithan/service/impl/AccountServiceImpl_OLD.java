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
public class AccountServiceImpl_OLD implements IAccountService{
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
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }
    }

    @Override
    public Account findAccountByid(Integer id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountByid(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }
    }

    @Override
    public void transfer(String source, String target, Float money) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
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

            int i = 1 / 0;
            //6. 更新转入账户
            accountDao.updateAccount(accoutTarget);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollBack();
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            transactionManager.close();
        }


    }
}
