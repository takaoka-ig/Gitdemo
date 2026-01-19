package com.example.attendance.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.attendance.dto.AttendanceView;
import com.example.attendance.mapper.AttendanceMapper;
import com.example.attendance.model.Attendance;
import com.example.attendance.model.User;

@Service
public class AttendanceService {

	private static final Logger log = LogManager.getLogger(AttendanceService.class);

	private final AttendanceMapper attendanceMapper;
	private final UserService userService;

	public AttendanceService(
			AttendanceMapper attendanceMapper,
			UserService userService) {
		this.attendanceMapper = attendanceMapper;
		this.userService = userService;
	}

	public List<AttendanceView> getTodayAttendances() {
		LocalDate today = LocalDate.now();
		log.info("本日の出席者一覧取得 date={}", today);
		return attendanceMapper.findByDate(today);
	}

	@Transactional
	public void register(String unit, String username, LocalDate inputDate) {

		log.info("出席登録開始 unit={}, username={}, date={}",
				unit, username, inputDate);

		try {
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
			boolean exists = attendanceMapper.existsByUserIdAndDate(userId, inputDate);

			if (exists) {
				log.warn("二重登録検知 userId={}, date={}", userId, inputDate);
				throw new IllegalStateException(
						inputDate + " はすでに出席登録されています。");
			}

			// 出席登録
			Attendance attendance = new Attendance();
			attendance.setUserId(userId);
			attendance.setInputDate(inputDate);

			attendanceMapper.insert(attendance);

			log.info("出席登録完了 userId={}, date={}", userId, inputDate);

		} catch (IllegalStateException e) {
			// エラー（想定内）
			log.warn("業務エラー: {}", e.getMessage());
			throw e;

		} catch (Exception e) {
			// 想定外エラー
			log.error(
					"出席登録中に想定外エラーが発生しました unit={}, username={}, date={}",
					unit, username, inputDate,
					e);
			throw e;
		}

	}

	@Transactional
	public void changeStatus(
			Integer attendanceId,
			String status) {

		log.info("出席状態更新 id={}, status={}", attendanceId, status);
		attendanceMapper.updateStatus(attendanceId, status);
	}

	@Transactional
	public void changeDate(
			Integer attendanceId,
			LocalDate newDate) {

		log.info("出席日付更新 id={}, date={}", attendanceId, newDate);
		attendanceMapper.updateDate(attendanceId, newDate);
	}

}
