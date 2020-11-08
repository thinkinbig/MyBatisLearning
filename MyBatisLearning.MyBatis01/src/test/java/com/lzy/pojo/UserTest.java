package com.lzy.pojo;

import com.lzy.mapper.UserMapper;
import com.lzy.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private SqlSession session = MyBatisUtils.newSqlSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);
    @Test
    public void test_list() {
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void test_getUserById() {
        for (int i = 0; i < userMapper.getUsers().size(); ++i) {
            User user = userMapper.getUserById(i + 1);
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void test_addUser() {
        User user = new User(1, "lzy", "8888");
        if (userMapper.addUser(user)) { System.out.println("insert successfully"); }
        // session.commit();
        session.close();
    }

    @Test
    public void test_updateUser() {
        userMapper.updateUser(new User(4, "Rick", "I hate Morty"));
        // session.commit();
        session.close();
    }

    @Test
    public void test_deleteUser() {
        userMapper.deleteUser(1);
        // session.commit();
        session.close();
    }
}
