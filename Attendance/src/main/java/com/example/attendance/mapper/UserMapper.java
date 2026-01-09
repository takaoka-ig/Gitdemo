package com.example.attendance.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.attendance.model.User;

@Mapper
public interface UserMapper {

    User findByNameAndUnit(String name, String unit);

    void insert(User user);
}
