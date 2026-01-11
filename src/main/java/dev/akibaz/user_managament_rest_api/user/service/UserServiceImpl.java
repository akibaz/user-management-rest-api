package dev.akibaz.user_managament_rest_api.user.service;

import dev.akibaz.user_managament_rest_api.exception.ResourceNotFoundException;
import dev.akibaz.user_managament_rest_api.user.dao.UserRepository;
import dev.akibaz.user_managament_rest_api.user.dto.UserRequestDto;
import dev.akibaz.user_managament_rest_api.user.dto.UserResponseDto;
import dev.akibaz.user_managament_rest_api.user.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .active(true)
                .build();

        User saved = userRepository.save(user);
        return mapToDto(saved);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .filter(User::isActive)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapToDto(user);
    }

    @Override
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userRepository.findAllByActiveTrue(pageable)
                .map(this::mapToDto);
    }

    @Override
    public void deleteUserByID(Long id) {
        User user = userRepository.findById(id)
                .filter(User::isActive)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));

        user.setActive(false);
    }

    private UserResponseDto mapToDto(User saved) {
        return UserResponseDto.builder()
                .id(saved.getId())
                .firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .email(saved.getEmail())
                .build();
    }

}
