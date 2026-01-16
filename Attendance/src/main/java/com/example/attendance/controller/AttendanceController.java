package com.example.attendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.attendance.dto.AttendanceView;
import com.example.attendance.service.AttendanceService;

@Controller
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendance")
    public String showForm(Model model) {
        model.addAttribute("message", "出席登録画面");
        return "attendance";
    }

    @PostMapping("/attendance")
    public String submit(
            @RequestParam("unit") String unit,
            @RequestParam("username") String username,
            @RequestParam("inputDate") String inputDate,
            Model model) {

        attendanceService.register(
            unit,
            username,
            LocalDate.parse(inputDate)
        );

        model.addAttribute(
            "message",
            "出席登録しました：" + unit + " / " + username + " / " + inputDate
        );

        return "attendance";
    }
    
    @GetMapping("/attendance/today")
    public String showTodayAttendance(Model model) {

        List<AttendanceView> list =
            attendanceService.getTodayAttendances();

        model.addAttribute("date", LocalDate.now());
        model.addAttribute("attendanceList", list);

        return "attendance-today";
    }
}
