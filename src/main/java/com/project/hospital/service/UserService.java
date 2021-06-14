package com.project.hospital.service;

import com.project.hospital.dto.UserDto;
import com.project.hospital.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public List<UserDto> getAllUsers();

}
