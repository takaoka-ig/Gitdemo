package com.example.attendance.dto;

import java.time.LocalDate;

public class AttendanceView {

    private String unit;
    private String username;
    private LocalDate inputDate;

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

    public LocalDate getInputDate() {
        return inputDate;
    }
    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}
