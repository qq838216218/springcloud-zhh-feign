package com.jk.service;

import com.jk.model.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();

    void addUser(User user);

    void deleteUser(Integer userId);

    User queryById(Integer userId);

    void updateUser(User user);
}
