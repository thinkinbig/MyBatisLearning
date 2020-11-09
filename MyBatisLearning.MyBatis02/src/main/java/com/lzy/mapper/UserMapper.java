package com.lzy.mapper;

import com.lzy.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUsers();

    List<User> getOrderedUsers();

    List<User> getUsersByLimit(Map<String, Integer> map);

    List<User> getUsersByRowBounds();

    User getUserById(int id);

    String getPassById(int id);

    List<User> getUserNameLike(String value);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
