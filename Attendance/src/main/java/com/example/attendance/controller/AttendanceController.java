package com.example.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendanceController {

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

		model.addAttribute(
				"message",
				"出席登録しました：" + unit + " / " + username + " / " + inputDate);
		return "attendance";
	}
}