package com.lzy.bean;

import com.lzy.mapper.UserMapper;
import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void setUp() {
        session = MyBatisUtils.newSqlSession();
        userMapper = session.getMapper(UserMapper.class);
    }


    @After
    public void tearDown() {
        session.close();
    }

    @Test
    public void test_list() {
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test_like() {
        List<User> userLike = userMapper.getUserNameLike("%li%");
        userLike.forEach((u) -> System.out.println(u));
        List<User> users = userMapper.getOrderedUsers();
        System.out.println(users);
    }

    @Test
    public void test_getUserById() {
        System.out.println(userMapper.getUserById(1));
    }

    @Test
    public void test_addUser() {
        User user = new User(1, "lzy", "8888");
        if (userMapper.addUser(user)) { System.out.println("insert successfully"); }
        // session.commit();
    }

    @Test
    public void test_updateUser() {
        userMapper.updateUser(new User(4, "Rick", "I hate Morty"));
        // session.commit();
    }

    @Test
    public void test_deleteUser() {
        userMapper.deleteUser(1);
        // session.commit();
    }
}
