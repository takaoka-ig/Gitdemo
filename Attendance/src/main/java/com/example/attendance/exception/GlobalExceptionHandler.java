package com.example.attendance.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalState(
            IllegalStateException e,
            Model model) {

        model.addAttribute("message", e.getMessage());
        return "attendance";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(
            Exception e,
            Model model) {

        model.addAttribute(
            "message",
            "システムエラーが発生しました。管理者に連絡してください。"
        );
        return "attendance";
    }
}
