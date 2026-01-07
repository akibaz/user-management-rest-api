package dev.akibaz.user_managament_rest_api.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
