package com.example.attendance.model;

import java.time.LocalDate;

public class Attendance {

	private Integer attendanceId;
    private Integer userId;
    private LocalDate inputDate;

    public Integer getAttendanceId() {
        return attendanceId;
    }
    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public LocalDate getInputDate() {
        return inputDate;
    }
    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}
