package com.ithan;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试queryRunner是否是单例对象
 */
public class TestQueryRunner {
    @Test
    public void testQueryRunner(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner1 = context.getBean("queryRunner", QueryRunner.class);
        QueryRunner queryRunner2 = context.getBean("queryRunner", QueryRunner.class);

        System.out.println(queryRunner1 == queryRunner2);
    }
}
