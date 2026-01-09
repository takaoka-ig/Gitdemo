package com.example.attendance.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.attendance.model.Attendance;

@Mapper
public interface AttendanceMapper {

    void insert(Attendance attendance);
}
