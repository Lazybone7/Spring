# Spring整合Junit
1、整个程序的入口：main方法

2、在junit单元测试中，没有main方法也能执行
    从该方法就会判断当前测试类中哪些方法有@Test注解
    junit就让有Test注解的方法执行
    
3、spring不会管我们是否采用spring框架
    在执行测试方法时，junit根本不知道我们是不是使用了
    spring框架。所以也就不会为我们读取配置文件/配置类
    创建spring核心容器

4、由以上三点得知，当测试方法执行时，没有IOC容器就算写
    了AutoWired注解，也无法实现注入
    
    
    
    
# 使用junit单元测试

 Spring整合junit的配置
    1. 导入spring整合junit的jar包
    2. 使用junit提供的一个注解把原有的main方法替换了，替换成spring提供
          的 @Runwith
    3. 告知spring的运行器，spring和IOC创建是基于xml还是注解的，并说明位置
        @ContextConfiguration
            属性：
                locations：指明xml文件的位置，加上classpath关键字，表示在类路径下
                classes：指定注解类所在的位置
    细节：当使用Spring5.x版本时，要求junit的版本必须是4.12及以上