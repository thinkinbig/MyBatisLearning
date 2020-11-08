package com.lzy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtils {

    private static String config = "mybatis-config.xml";

    public static SqlSession newSqlSession() {

        try {
            return new SqlSessionFactoryBuilder()
                            .build(Resources.getResourceAsStream(config)).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
