package com.lzy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static volatile SqlSession session = null;
    private static String config = "mybatis-config.xml";

    public static SqlSession getSqlSession() {
        if (session != null) {
            return session;
        }

        synchronized (MyBatisUtils.class) {
            if (session != null) {
                return session;
            }
            try {
                final InputStream resourceAsStream = Resources.getResourceAsStream(config);
                final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
                session = build.openSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return session;
        }
    }
}
