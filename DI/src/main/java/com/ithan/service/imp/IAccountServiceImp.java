package com.ithan.service.imp;
import com.ithan.service.IAccountService;

import java.util.Date;

public class IAccountServiceImp implements IAccountService {

    /**
     * 需要经常变化的数据并不适合这种注入方式
     */
    private String name;
    private Integer age;
    private Date birthday;

    public IAccountServiceImp(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount," + name + "," + age + "," + birthday);
    }
}
