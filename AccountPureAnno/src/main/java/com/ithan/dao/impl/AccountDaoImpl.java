package com.ithan.dao.impl;

import com.ithan.dao.IAccountDao;
import com.ithan.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;
import java.util.List;

/**
 * 持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao{
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAllAccount() {
        try{
            return queryRunner.query("SELECT * FROM account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByid(Integer id) {
        try {
            return queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name = ? , money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            queryRunner.update("delete from account where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
