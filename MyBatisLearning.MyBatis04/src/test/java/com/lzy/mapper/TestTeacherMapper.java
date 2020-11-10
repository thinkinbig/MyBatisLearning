package com.lzy.mapper;

import com.lzy.bean.Teacher;
import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTeacherMapper {
    private static final Logger logger =
            Logger.getLogger(TestTeacherMapper.class);
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
    public void testGetTeacherById() {
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherByTid(1);
        logger.info(teacher);
    }
}
