package com.lzy.mapper;

import com.lzy.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("SELECT * FROM mybatis.users")
    List<User> getUsers();

    @Select("SELECT * FROM mybatis.users ORDER BY id DESC")
    List<User> getOrderedUsers();

    @Select("SELECT * FROM mybatis.users WHERE id=#{id}")
    User getUserById(@Param("id") int id);

    @Select("SELECT pwd FROM mybatis.users WHERE id=#{id}")
    List<User> getUserNameLike(@Param("value") String value);

    @Select("SELECT * FROM mybatis.users LIMIT #{map[startIndex]}, #{map[pageSize]}")
    List<User> getUsersByLimit(@Param("map") Map<String, Integer> map);

    @Insert("INSERT INTO mybatis.users (id, name, pwd) VALUES (#{id}, #{name}, #{pwd})")
    boolean addUser(@Param("user") User user);

    @Update("UPDATE mybatis.users SET name=#{name}, pwd=#{pwd} WHERE id=#{id}")
    boolean updateUser(@Param("user")User user);

    @Delete("DELETE FROM mybatis.users WHERE id=#{id}")
    boolean deleteUser(@Param("id")int id);
}
