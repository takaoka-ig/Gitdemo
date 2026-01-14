package com.example.attendance.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.attendance.mapper.AttendanceMapper;
import com.example.attendance.model.Attendance;
import com.example.attendance.model.User;

@Service
public class AttendanceService {

    private final AttendanceMapper attendanceMapper;
    private final UserService userService;

    public AttendanceService(
            AttendanceMapper attendanceMapper,
            UserService userService) {
        this.attendanceMapper = attendanceMapper;
        this.userService = userService;
    }

    @Transactional
    public void register(String unit, String username, LocalDate inputDate) {

        // ユーザー取得（なければ作成）
        User user = userService.findByNameAndUnit(username, unit);
        if (user == null) {
            user = new User();
            user.setName(username);
            user.setUnit(unit);
            userService.insert(user);
        }

        Integer userId = user.getUserId();

        // 重複チェック
        boolean exists =
            attendanceMapper.existsByUserIdAndDate(userId, inputDate);

        if (exists) {
            throw new IllegalStateException(
                inputDate + " はすでに出席登録されています。"
            );
        }

        // 出席登録
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setInputDate(inputDate);

        attendanceMapper.insert(attendance);
    }
}
