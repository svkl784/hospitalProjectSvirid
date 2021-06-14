package com.project.hospital.controller;

import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.dto.UserDto;
import com.project.hospital.model.entity.User;
import com.project.hospital.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showWelcome(Map<String, Object> model) {
        return "show-welcome";
    }

    @GetMapping("/userRegister")
    public String userRegister() {
        return "show-user-register";
    }


    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<UserDto> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }
}


//    @PostMapping(path = "/addNewUser") // Map ONLY POST Requests
//    public @ResponseBody
//    String addNewUser(@RequestParam String userName
//            , @RequestParam String email) {
//        User n = new User();
//        n.setUserName(userName);
//        n.setEmail(email);
//        userService.save(n);
//        return "Saved";
//    }
