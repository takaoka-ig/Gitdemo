package com.example.attendance.dto;

import java.time.LocalDate;

public class AttendanceView {

    private Integer attendanceId;
    private String unit;
    private String unitLabel; 	//日本語での画面表示用
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
        this.unitLabel = convertUnitLabel(unit);
    }
    
    public String getUnitLabel() {
        return unitLabel;
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
    
    private String convertUnitLabel(String unit) {
        return switch (unit) {
            case "ict"   -> "ICT";
            case "dxservice" -> "DXサービス";
            case "dxcloud"    -> "DXクラウド";
            case "media" -> "メディア";
            case "innovation"   -> "イノベーション";
            case "socialcommunication" -> "社会通信";
            case "corporatecommunication"    -> "法人通信";
            case "public" -> "公共";
            case "social"   -> "社会";
            case "expert" -> "エキスパート";
            case "sales"    -> "営業";
            case "business" -> "業務";
            default      -> unit;
        };
    }
}
