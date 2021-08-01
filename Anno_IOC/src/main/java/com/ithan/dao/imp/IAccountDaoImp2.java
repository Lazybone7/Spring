package com.ithan.dao.imp;

import com.ithan.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class IAccountDaoImp2 implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户22222222222");
    }
}
