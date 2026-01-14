package com.example.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendance.mapper.UserMapper;
import com.example.attendance.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 名前とユニットで検索
    @GetMapping("/search")
    public User findByNameAndUnit(@RequestParam String name, @RequestParam String unit) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("unit", unit);

        return userMapper.findByNameAndUnit(name, unit);
    }

    // 新規ユーザーを追加
    @PostMapping("/add")
    public String insertUser(@RequestBody User user) {
        userMapper.insert(user);
        return "User inserted with ID: " + user.getUserId();
    }
}
