package com.project.hospital.controller;

import com.project.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showWelcome(){
        return "show-welcome";
    }

    @RequestMapping("/userRegister")
    public String userRegister(){
        return "show-user-register";
    }


}
