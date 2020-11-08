package com.lzy.mapper;

import com.lzy.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    User getUserById(int id);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
