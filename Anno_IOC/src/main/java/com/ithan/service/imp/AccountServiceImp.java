package com.ithan.service.imp;
import com.ithan.dao.IAccountDao;
import com.ithan.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 注解的几种类型：
 *
 *  用于创建对象的
 *      他们的作用就和在XML配置文件中编写一个bean标签是一样的
 *          @Component：
 *              作用：将当前类对象存入spring容器中
 *              属性：value,用于指定bean的id。当不写时，默认值是当前类名，且首字母小写
 *          =========================================
 *          @Controller:    一般用于表现层
 *          @Service:   一般用于业务层
 *          @Repository:    一般用于持久层
 *          以上三个注解的作用与属性和@Component注解一模一样
 *          这三个是spring框架为我们提供明确的三层使用的注释，使三层对象更加清晰
 *
 *  用于注入数据的
 *      他们的作用和在xml配置文件中的bean标签中写一个property标签是一样的
 *          @Autowired
 *              作用：自动按类型注入; 只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，则注入成功
 *                      如果IOC容器中没有任何bean类型和要注入的类型匹配，则报错.
 *                      若有多个，首先根据变量名作为id查找，若唯一则注入成功，否则注入失败
 *              位置：变量；方法
*               细节：在使用注解注入时，set方法就不是必须的了
*           @Qualifier
 *              作用：在按照类中注入的基础之上再按照名称注入。他在给类成员赋值时不能单独使用，需要搭配@Autowired。但再给方法参数
 *                      注入时可以
*               属性：
 *                  value：用于指定注入bean的id
*           @Resource
 *              作用：直接按照bean的id注入。它可以独立使用
 *              属性：
*                  name：用于指定注入bean的id、
*           以上三个注入只能注入其他bean类型的数据，而基本数据类型和String类型无法使用上述注解实现
 *           另外，集合类型的注入只能通过xml来实现
 *          @Value
 *              作用：用于注入基本类型和String类型的数据
 *              属性：
 *                  value：用于指定数据的值。它可以使用SpEL(也就是spring的el表达式)
 *                  SpEL的写法：${表达式}
 *
 *    用于改变作用范围的：
 *      他们的作用就和在bean中使用scope属性实现是一样的
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：
*              value：指定范围的取值。常用取值：singleton prototype
 *
*     和生命周期相关的： 了解
 *          他们的作用就和在bean标签中使用init-method和destory-method的作用一样的
 *
 *          @PreDestory
 *              作用：用于指定销毁方法
 *          @PostConstruct
 *              作用：用于指定初始化方法
 */
@Service("accountService")
@Scope("prototype")
public class AccountServiceImp implements IAccountService {
    @Autowired
    private IAccountDao accountDao1;

    public AccountServiceImp() {
        System.out.println("对象创建了。。");
    }

    public void saveAccount() {
        accountDao1.saveAccount();
    }
}
