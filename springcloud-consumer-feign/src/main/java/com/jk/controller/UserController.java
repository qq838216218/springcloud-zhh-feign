package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserServiceFeign userServiceFeign;

    @RequestMapping("/queryUser")
    public String queryUser(Model model, HttpServletResponse response) throws IOException {
        List<User> userList = userServiceFeign.queryUser();
       // 请求失败时，对熔断器返回的数据进行处理
        if (userList==null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        model.addAttribute("userList",userList);
        return "main";
    }

    @RequestMapping("/toAdd")
    public String  toAdd(){
        return "add";
    }


    @RequestMapping("/addUser")
    public String  addUser(User user,HttpServletResponse response) throws IOException {

        userServiceFeign.addUser(user);
       return"redirect:queryUser";
    }
    @RequestMapping("/deleteUser")
    public String  deleteUser(Integer userId,HttpServletResponse response) throws IOException {
        userServiceFeign.deleteUser(userId);
       return"redirect:queryUser";
    }
    @RequestMapping("/queryById")
    public String  queryById(Integer userId,Model model, HttpServletResponse response) throws IOException {
        User  user = userServiceFeign.queryById(userId);
        model.addAttribute("user",user);
        return"update";
    }
    @RequestMapping("/updateUser")
    public String  updateUser(User user, HttpServletResponse response) throws IOException {

        userServiceFeign.updateUser(user);

        return"redirect:queryUser";
    }


    public static void main(String[] args) {
        System.out.println("test123 update!!!!!!!!!!!!!!!!!!!");
        System.out.println("test2563!!!!!!!");
    }


}
ge