package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.service.UserServiceFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class UserController implements UserServiceFeign {
    @Resource
    private UserService userService;
    @RequestMapping("/queryUser")
    public List<User> queryUser() {
        return userService.queryUser();
    }

    @PostMapping("/addUser")
    @Override
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @RequestMapping("/deleteUser")
    @Override
    public void deleteUser(@RequestParam("userId") Integer userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping("/queryById")
    @Override
    public User queryById(@RequestParam("userId") Integer userId ) {
        return userService.queryById(userId);
    }
    @PutMapping("/updateUser")
    @Override
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
