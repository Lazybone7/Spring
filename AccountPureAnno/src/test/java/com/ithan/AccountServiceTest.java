package com.ithan;

import config.SpringConfiguration;
import com.ithan.domain.Account;
import com.ithan.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * 使用junit单元测试
 *
 * Spring整合junit的配置
 *      1. 导入spring整合junit的jar包
 *      2. 使用junit提供的一个注解把原有的main方法替换了，替换成spring提供
 *          的 @Runwith
 *      3. 告知spring的运行器，spring和IOC创建是基于xml还是注解的，并说明位置
 *          @ContextConfiguration
 *              locations：指明xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *      细节：当使用Spring5.x版本时，要求junit的版本必须是4.12及以上
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){
       // ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account: allAccount){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountByid(2);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test anno");
        account.setMoney(15.12f);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);
        Account account1 = accountService.findAccountByid(4);
        System.out.println(account1);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountByid(5);
        account.setName("ggg");
        accountService.updateAccount(account);
        Account account1 = accountService.findAccountByid(5);
        System.out.println(account1);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(5);
        Account account1 = accountService.findAccountByid(5);
        System.out.println(account1);
    }



}
