package com.sparta.miniproject_team4.service;

import com.sparta.miniproject_team4.dto.SignupRequestDto;
import com.sparta.miniproject_team4.model.Users;
import com.sparta.miniproject_team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<Users> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        String email = requestDto.getEmail();
        Optional<Users> foundEmail = userRepository.findByEmail(email);
        if (foundEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 email이 존재합니다.");
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());





        Users users = new Users(username, password, email);
        userRepository.save(users);
        return users;
    }
}