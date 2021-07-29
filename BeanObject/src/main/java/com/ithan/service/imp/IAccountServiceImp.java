package com.ithan.service.imp;
import com.ithan.service.IAccountService;

public class IAccountServiceImp implements IAccountService {
    public void saveAccount() {
        System.out.println("service中的saveAccount");
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destory(){
        System.out.println("对象销毁");
    }

}
