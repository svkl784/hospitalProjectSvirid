package com.project.hospital.model.dao;


import com.project.hospital.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
