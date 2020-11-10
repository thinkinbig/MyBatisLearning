package com.lzy.mapper;

import com.lzy.bean.Student;
import com.lzy.bean.Teacher;
import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestStudentMapper {

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
    public void test_getStudents() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.getStudents().forEach((s) -> logger.info(s));
    }

    @Test
    public void test_getStudentById() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudentById(1);
        logger.info(student);
    }

    @Test
    public void test_getTeacher() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Teacher teacher = studentMapper.getTeacher(2);
        logger.info(teacher);
    }
}
