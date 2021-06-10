package com.project.hospital.controller;

import com.project.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping  ("/")
    public String showWelcome(Model model){
        return "showWelcome";
    }


    @RequestMapping("/userRegister")
    public String userRegister(){
        return "showUserRegister";
    }


}
