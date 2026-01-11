package dev.akibaz.user_managament_rest_api.user.service;

import dev.akibaz.user_managament_rest_api.user.dto.UserRequestDto;
import dev.akibaz.user_managament_rest_api.user.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    Page<UserResponseDto> getAllUsers(Pageable pageable);
    void deleteUserByID(Long id);
}
