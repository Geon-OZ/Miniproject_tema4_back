package com.sparta.miniproject_team4.controller;

import com.sparta.miniproject_team4.dto.SignupRequestDto;
import com.sparta.miniproject_team4.security.UserDetailsImpl;
import com.sparta.miniproject_team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

//    // 회원 로그인 페이지
//    @GetMapping("/users/login")
//    public String login() {
//        return "login";
//    }
//
//    // 회원 가입 페이지
//    @GetMapping("/users/register")
//    public String signup() {
//        return "signup";
//    }

    // 회원 가입 요청 처리
    @PostMapping("/users/register")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "/";
    }
// 유저 로그인 체크(삭제예정_HTML테스트용)
//    @GetMapping("/api/userCheck")
//    public String userCheck(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails != null) {
//            return userDetails.getUser().getUsername();
//        }
//        return "";
//    }



}