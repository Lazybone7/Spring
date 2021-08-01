package com.ithan.dao.imp;

import com.ithan.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class IAccountDaoImp implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户11111111");
    }
}
