package com.lzy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtils {

    private static String config = "mybatis-config.xml";
    private static SqlSessionFactory factory;

    public static SqlSession newSqlSession() {
        if (factory == null) {
            synchronized (MyBatisUtils.class) {
                if (factory == null) {
                    try {
                        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory.openSession();
    }
}
