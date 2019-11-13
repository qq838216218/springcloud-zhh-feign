package com.jk.dao;

import com.jk.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {


    List<User> queryUser();

    void addUser(User user);

    void deleteUser(Integer userId);

    User queryById(Integer userId);

    void updateUser(User user);
}
