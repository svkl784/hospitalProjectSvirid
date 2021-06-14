package com.project.hospital.service.impl;
import com.project.hospital.dto.UserDto;
import com.project.hospital.model.dao.UserDao;
import com.project.hospital.model.entity.User;
import com.project.hospital.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user1 -> {
            UserDto userDto = new UserDto();
            userDto.setId_user(user1.getId_user());
            userDto.setUserName(user1.getUserName());
            userDto.setEmail(user1.getEmail());
            userDto.setPassword(user1.getPassword());
            userDtos.add(userDto);
        });
        return userDtos;
    }




}

