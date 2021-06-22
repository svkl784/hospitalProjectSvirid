package com.project.hospital.service.impl;

import com.project.hospital.dto.UserDto;
import com.project.hospital.model.dao.RoleDao;
import com.project.hospital.model.dao.UserDao;
import com.project.hospital.model.entity.Role;
import com.project.hospital.model.entity.User;
import com.project.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService ,UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) user;
    }

    @Override
    public boolean saveUser(User user) {
        User userFromDB = userDao.findByUserName(user.getUserName());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return true;
    }

    @Override
    public User findUserById(Long id_user) {
        Optional<User> userFromDb = userDao.findById(id_user);
        return userFromDb.orElse(new User());
    }

    @Override
    public boolean deleteUser(Long id_user) {
        if (userDao.findById(id_user).isPresent()) {
            userDao.deleteById(id_user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id_user > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user1 -> {
            UserDto userDto = new UserDto();
            userDto.setId_user(user1.getId_user());
            userDto.setUserName(user1.getUserName());
            userDto.setPassword(user1.getPassword());
            userDtos.add(userDto);
        });
        return userDtos;
    }


}

