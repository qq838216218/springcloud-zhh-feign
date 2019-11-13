package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "provider-feign",fallback = UserServiceError.class)
public interface UserServiceFeign {

    @GetMapping("/queryUser")
    List<User> queryUser();

    @PostMapping("/addUser")
    void addUser(@RequestBody User user);

    @RequestMapping("/deleteUser")
    void deleteUser(@RequestParam("userId") Integer userId);

    @GetMapping("/queryById")
    User queryById(@RequestParam("userId") Integer userId);

    @PutMapping("/updateUser")
    void updateUser(@RequestBody User user);
}
