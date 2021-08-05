package com.ithan.service;

import com.ithan.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Account findAccountByid(Integer id);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 转账
     * @param source    转出账户
     * @param target    转入账户
     * @param money     转账金额
     */
    void transfer(String source, String target, Float money);

}
