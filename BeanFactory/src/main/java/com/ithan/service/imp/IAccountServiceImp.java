package com.ithan.service.imp;
import com.ithan.dao.IAccountDao;
import com.ithan.factory.BeanFactory;
import com.ithan.service.IAccountService;

public class IAccountServiceImp implements IAccountService {
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
    }
}
