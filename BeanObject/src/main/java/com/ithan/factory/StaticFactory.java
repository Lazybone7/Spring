package com.ithan.factory;

import com.ithan.service.IAccountService;
import com.ithan.service.imp.IAccountServiceImp;

public class StaticFactory {
    public static IAccountService getAccountService()
    {
        return new IAccountServiceImp();
    }
}
