package com.quadralivre.quadra_agendamentos_api.services.userService;

import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto updateUser(Long id, UserRequestDto userDto);
    void deleteUser(Long id);
}
