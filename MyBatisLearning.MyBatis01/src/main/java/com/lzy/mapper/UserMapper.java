package com.lzy.mapper;

import com.lzy.bean.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    List<User> getOrderedUsers();

    User getUserById(int id);

    List<User> getUserNameLike(String value);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
