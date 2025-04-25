package com.sumwb.rn_version_update_backend.controller;

import com.sumwb.rn_version_update_backend.domain.User;
import com.sumwb.rn_version_update_backend.dto.login.LoginRequest;
import com.sumwb.rn_version_update_backend.dto.signup.SignupRequest;
import com.sumwb.rn_version_update_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final UserRepository userRepository;


    @PostMapping("/signup")
    public String signUp(@RequestBody SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "이미 존재하는 이메일입니다.";
        }

        userRepository.save(new User(request.getEmail(), request.getPassword()));
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userRepository.findByEmail(request.getId())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> "로그인 성공")
                .orElse("이메일 또는 비밀번호가 올바르지 않습니다.");
    }
}
