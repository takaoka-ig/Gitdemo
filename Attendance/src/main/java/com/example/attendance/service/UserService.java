package com.example.attendance.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.attendance.mapper.UserMapper;
import com.example.attendance.model.User;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public User insert(User user) {
        userMapper.insert(user);

        // insert失敗時の保険
        if (user.getUserId() == null) {
            throw new RuntimeException("User insert failed");
        }
        return user;
    }

    public User findByNameAndUnit(String name, String unit) {
        return userMapper.findByNameAndUnit(name, unit);
    }
}
