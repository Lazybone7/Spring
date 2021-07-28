package com.ithan.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties pro;
    private static Map<String, Object> beans;
    static {
        try {
            pro = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pro.load(is);
            beans = new HashMap<String, Object>();
            Enumeration keys = pro.keys();
            while(keys.hasMoreElements())
            {
                String key = keys.nextElement().toString();
                String beanPath = pro.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e)
        {
            throw new ExceptionInInitializerError("对象初始化失败");
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
