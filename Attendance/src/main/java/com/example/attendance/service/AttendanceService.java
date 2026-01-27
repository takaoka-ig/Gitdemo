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

	private String convertUnitLabel(String unit) {
		switch (unit) {
		case "ict":
			return "ICT";

		case "dxservice":
			return "DXサービス";

		case "dxcloud":
			return "DXクラウド";

		case "media":
			return "メディア";

		case "innovation":
			return "イノベーション";

		case "socialcommunication":
			return "社会通信";

		case "corporatecommunication":
			return "法人通信";

		case "public":
			return "公共";

		case "social":
			return "社会";

		case "expert":
			return "エキスパート";

		case "sales":
			return "営業";

		case "business":
			return "業務";

		default:
			return unit; // 想定外はそのまま
		}
	}

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
	public void register(String unit, String username, LocalDate attendanceDate) {

		log.info("出席登録開始 unit={}, username={}, date={}",
				unit, username, attendanceDate);

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
			boolean exists = attendanceMapper.existsByUserIdAndDate(userId, attendanceDate);

			if (exists) {
				log.warn("二重登録検知 userId={}, date={}", userId, attendanceDate);
				throw new IllegalStateException(
						  unit + " / " + username + " / " + attendanceDate+ " はすでに出席登録されています。");
			}

			// 出席登録
			Attendance attendance = new Attendance();
			attendance.setUserId(userId);
			attendance.setattendanceDate(attendanceDate);

			attendanceMapper.insert(attendance);

			log.info("出席登録完了 userId={}, date={}", userId, attendanceDate);

		} catch (IllegalStateException e) {
			// エラー（想定内）
			log.warn("業務エラー: {}", e.getMessage());
			throw e;

		} catch (Exception e) {
			// 想定外エラー
			log.error(
					"出席登録中に想定外エラーが発生しました unit={}, username={}, date={}",
					unit, username, attendanceDate,
					e);
			throw e;
		}

	}

	@Transactional
	public void updateAttendance(
			Integer attendanceId,
			String status,
			LocalDate attendanceDate) {

		log.info("出席更新 id={}, status={}, date={}",
				attendanceId, status, attendanceDate);

		attendanceMapper.updateAttendance(attendanceId, status, attendanceDate);
	}

	public AttendanceView getAttendance(Integer attendanceId) {
		log.info("出席情報取得 id={}", attendanceId);

		return attendanceMapper.findById(attendanceId);

	}

	public List<AttendanceView> getAttendancesByDate(LocalDate date) {
		log.info("出席者一覧取得 date={}", date);
		return attendanceMapper.findByDate(date);

	}

	public List<AttendanceView> searchAttendances(LocalDate date, String unit, String username) {
		log.info("検索 date={}, unit={}, username={}", date, unit, username);
	    return attendanceMapper.search(date, unit, username);

	}
}
