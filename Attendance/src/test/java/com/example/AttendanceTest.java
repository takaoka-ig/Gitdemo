package com.example;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.attendance.mapper.AttendanceMapper;
import com.example.attendance.service.AttendanceService;
import com.example.attendance.service.UserService;

class AttendanceTest {
	
	

	@Test //登録
	void attendanceServiceTest() {
		
		String unit = "dxservice";
		String username = "高岡春陽";
		LocalDate attendanceDate = 
				LocalDate.of(2026,1,30);
		
		AttendanceMapper attmap = null;
		UserService us = null; 
		
		
		AttendanceService attser = new AttendanceService(attmap, us);
		attser.register(unit, username, attendanceDate);
	
	}

}
