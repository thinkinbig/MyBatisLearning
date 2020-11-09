package com.lzy.mapper;

import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestUserMapper {

    private static final Logger logger =
            Logger.getLogger(TestUserMapper.class);

    @Test
    public void test_log4j() {
        logger.info("info:enter into " + this.getClass().getName());
        logger.debug("debug:enter into " + this.getClass().getName());
        logger.error("error:enter into " + this.getClass().getName());
    }

    @Test
    public void test_limit() {
        SqlSession session = MyBatisUtils.newSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        logger.debug(mapper.getUsersByLimit(map));
    }
}
