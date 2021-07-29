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
       // ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //方式二：ClassPathXmlApplicationContext 类路径
        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Han\\Desktop\\bean.xml");

        //2. 通过反射获取对象
        IAccountService accountService = context.getBean("accountService",IAccountService.class);
        accountService.saveAccount();
        for (int i = 0; i < 6; i++) {
            System.out.println(accountService);
        }


        /*---------BeanFactory-------------------*/
        /*
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        IAccountService accountService = beanFactory.getBean("accountService",IAccountService.class);
        accountService.saveAccount();
        */
    }
}
