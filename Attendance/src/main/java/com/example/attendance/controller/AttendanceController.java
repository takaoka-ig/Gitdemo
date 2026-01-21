package com.example.attendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.attendance.dto.AttendanceView;
import com.example.attendance.service.AttendanceService;

@Controller
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	@GetMapping("/attendance")
	public String showForm(Model model) {
		model.addAttribute("message", "出席登録画面");
		return "attendance";
	}

	@PostMapping("/attendance")
	public String submit(
			@RequestParam("unit") String unit,
			@RequestParam("username") String username,
			@RequestParam("inputDate") String inputDate,
			Model model) {

		attendanceService.register(
				unit,
				username,
				LocalDate.parse(inputDate));

		model.addAttribute(
				"message",
				"出席登録しました：" + unit + " / " + username + " / " + inputDate);

		return "attendance";
	}

	@GetMapping("/attendance/today")
	public String showTodayAttendance(Model model) {

		List<AttendanceView> list = attendanceService.getTodayAttendances();

		model.addAttribute("date", LocalDate.now());
		model.addAttribute("attendanceList", list);

		return "attendance-today";
	}

	@PostMapping("/attendance/update")
	public String update(
	    @RequestParam Integer attendanceId,
	    @RequestParam String status,
	    @RequestParam LocalDate inputDate,
	    RedirectAttributes redirectAttributes) {

	    attendanceService.updateAttendance(attendanceId, status, inputDate);
	    
	    redirectAttributes.addFlashAttribute(
	            "successMessage",
	            "出席情報を更新しました"
	        );
	    return "redirect:/attendance/today";
	}

	@GetMapping("/attendance/edit")
	public String showEdit(
	    @RequestParam("attendanceId") Integer attendanceId,
	    Model model) {


	    AttendanceView attendance =
	        attendanceService.getAttendance(attendanceId);

	    model.addAttribute("attendance", attendance);

	    return "attendance-edit";
	}

	@GetMapping("/attendance/search")
	public String search(
	    @RequestParam(required = false) LocalDate date,
	    Model model) {

	    // 日付未指定なら今日
	    LocalDate targetDate =
	        (date != null) ? date : LocalDate.now();

	    List<AttendanceView> list =
	        attendanceService.getAttendancesByDate(targetDate);

	    model.addAttribute("date", targetDate);
	    model.addAttribute("attendanceList", list);

	    return "attendance-search";
	}

	
	
	
}
