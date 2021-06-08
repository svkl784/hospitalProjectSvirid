package com.project.hospital.model.dao;


import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao  extends JpaRepository<User, Long> {
    void deleteUser(User user);
    void createOrUpdate(User user);
    List<User> getAllUser();

}