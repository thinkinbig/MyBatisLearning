package com.lzy.mapper;

import com.lzy.bean.User;
import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserMapper {

    private static final Logger logger =
            Logger.getLogger(TestUserMapper.class);
    private static final String mapper = "com.lzy.mapper.UserMapper.getUsersByRowBounds";
    private SqlSession session;

    @Before
    public void setUp() {
        session = MyBatisUtils.newSqlSession();
        logger.info("\ninfo: enter into " + this.getClass().getName());
    }

    @After
    public void tearDown() {
        logger.info("info: exit " + this.getClass().getName() + "\n");
        session.close();
    }

    @Test
    public void test_limit() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        logger.debug(mapper.getUsersByLimit(map));
    }

    @Test
    public void getUserByRowBounds() {

        RowBounds rowBounds = new RowBounds(1, 3);

        List<User> users = session.selectList(
                mapper, null, rowBounds);
        logger.debug(users);

    }
}
