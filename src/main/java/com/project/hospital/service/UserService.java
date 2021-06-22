package com.project.hospital.service;

import com.project.hospital.dto.UserDto;
import com.project.hospital.model.entity.User;

import java.util.List;

public interface UserService  {
    List<UserDto> getAllUsers();
    boolean saveUser(User user);
    User findUserById(Long id_user);
    public boolean deleteUser(Long id_user);
    List<User> usergtList(Long idMin);

}
