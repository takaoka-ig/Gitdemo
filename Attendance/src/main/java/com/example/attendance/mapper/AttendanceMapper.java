package com.example.attendance.mapper;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;

import com.example.attendance.model.Attendance;

@Mapper
public interface AttendanceMapper {

    void insert(Attendance attendance);

    boolean existsByUserIdAndDate(
        Integer userId,
        LocalDate inputDate
    );
}
