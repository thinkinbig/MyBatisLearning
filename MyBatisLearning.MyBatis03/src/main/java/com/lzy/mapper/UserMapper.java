package com.lzy.mapper;

import com.lzy.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("SELECT * FROM mybatis.users")
    List<User> getUsers();

    @Select("SELECT * FROM mybatis.users ORDER BY id DESC")
    List<User> getOrderedUsers();

    @Select("SELECT * FROM mybatis.users WHERE id=#{id}")
    User getUserById(int id);

    @Select("SELECT pwd FROM mybatis.users WHERE id=#{id}")
    List<User> getUserNameLike(String value);

    @Select("SELECT * FROM mybatis.users LIMIT #{startIndex}, #{pageSize}")
    List<User> getUsersByLimit(Map<String, Integer> map);

    @Insert("INSERT INTO mybatis.users (id, name, pwd) VALUES (#{id}, #{name}, #{pwd})")
    boolean addUser(User user);

    @Update("UPDATE mybatis.users SET name=#{name}, pwd=#{pwd} WHERE id=#{id}")
    boolean updateUser(User user);

    @Delete("DELETE FROM mybatis.users WHERE id=#{id}")
    boolean deleteUser(int id);
}
