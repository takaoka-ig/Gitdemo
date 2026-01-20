package com.example.attendance.dto;

import java.time.LocalDate;

public class AttendanceView {

    private Integer attendanceId;
    private String unit;
    private String username;
    private String status;
    private LocalDate inputDate;

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }
    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}
