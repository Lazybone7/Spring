package com.ithan.ui;
import com.ithan.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService",IAccountService.class);
        accountService.saveAccount();
        for (int i = 0; i < 5; i++) {
            System.out.println(accountService);
        }
    }
}
