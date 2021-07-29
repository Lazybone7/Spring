package com.ithan.ui;
import com.ithan.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * ApplicationContext： 立即加载(常用) 采用此接口
 * BeanFactory： 延迟加载
 */
public class Client {
    public static void main(String[] args) {
        //1. 获取核心容器对象
        //方式一：ClassPathXmlApplicationContext 类路径
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //2. 通过反射获取对象
        IAccountService as = context.getBean("accountService",IAccountService.class);
        IAccountService as2 = context.getBean("accountService",IAccountService.class);

        System.out.println(as == as2);

        //容器销毁
        context.close();

    }


}
