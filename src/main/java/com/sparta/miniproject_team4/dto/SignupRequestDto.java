package com.sparta.miniproject_team4.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SignupRequestDto {
    @Size(min = 3, max = 25)
    @NotBlank
    private String username;

    @Size(min=6, max=25)
    @NotBlank
    private String password;

    @NotBlank
    private String email;

}
