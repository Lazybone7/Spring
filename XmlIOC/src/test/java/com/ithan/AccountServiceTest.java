package com.ithan;

import com.ithan.domain.Account;
import com.ithan.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account: allAccount){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountByid(2);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("eee");
        account.setMoney(15.11f);
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);
        Account account1 = accountService.findAccountByid(4);
        System.out.println(account1);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountByid(5);
        account.setName("ggg");
        accountService.updateAccount(account);
        Account account1 = accountService.findAccountByid(5);
        System.out.println(account1);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(5);
        Account account1 = accountService.findAccountByid(5);
        System.out.println(account1);
    }



}
