package com.example.attendance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {

	private Integer attendanceId;
	private Integer userId;
	private LocalDate attendanceDate;
	private LocalDateTime createdAt;
	private String status; 

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

	public LocalDate getattendanceDate() {
		return attendanceDate;
	}

	public void setattendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
