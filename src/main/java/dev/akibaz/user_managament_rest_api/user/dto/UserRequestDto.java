package dev.akibaz.user_managament_rest_api.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank
    private  String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;
}

