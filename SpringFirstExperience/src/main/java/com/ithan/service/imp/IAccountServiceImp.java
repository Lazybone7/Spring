package com.ithan.service.imp;
import com.ithan.dao.IAccountDao;
import com.ithan.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountServiceImp implements IAccountService {
    private IAccountDao accountDao;

    public void saveAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        accountDao = context.getBean("accountDao",IAccountDao.class);
        accountDao.saveAccount();
    }
}
