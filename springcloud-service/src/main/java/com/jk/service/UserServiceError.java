package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceError implements UserServiceFeign{

    public List<User> queryUser() {
        // 将数据记录mongodb或者redis
        // 等服务器恢复，将数据存储到数据库中
        System.out.println("查询失败");
        return null;
    }

    public void addUser(User user) {
        System.out.println("新增商品有误，请检查");
    }

    public void deleteUser(Integer userId) {
        System.out.println("有误！！！");
    }

    public User queryById(Integer userId) {
        System.out.println("有误！！！");
        return null;
    }

    public void updateUser(User user) {
        System.out.println("sos");
    }
}
