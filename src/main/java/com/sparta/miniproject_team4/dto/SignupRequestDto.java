package com.sparta.miniproject_team4.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Setter
@Getter
public class SignupRequestDto {
    @Size(min = 3, max = 25)
    @NoEmpty
    private String username;
    private String password;
    private String email;

}
