package com.example.attendance.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.attendance.dto.AttendanceView;
import com.example.attendance.model.Attendance;

@Mapper
public interface AttendanceMapper {

	// 出席登録
	void insert(Attendance attendance);

	// 二重登録チェック
	boolean existsByUserIdAndDate(
			Integer userId,
			LocalDate inputDate);

	// 指定日の出席者一覧取得
	List<AttendanceView> findByDate(
			@Param("date") LocalDate date);

	// 出席／日付更新
	void updateAttendance(
			@Param("attendanceId") Integer attendanceId,
			@Param("status") String status,
			@Param("inputDate") LocalDate inputDate);

	AttendanceView findById(
			@Param("attendanceId") Integer attendanceId);

	//検索	
	List<AttendanceView> search(
			@Param("date") LocalDate date,
			@Param("unit") String unit,
			@Param("username") String username);
	
	//件数表示
	int searchCount(
			@Param("date") LocalDate date,
			@Param("unit") String unit,
			@Param("username") String username);

}
