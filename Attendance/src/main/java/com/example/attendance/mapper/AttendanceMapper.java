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
		    @Param("date") LocalDate date
		);
}
