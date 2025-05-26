package com.quadralivre.quadra_agendamentos_api.services.userService;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import com.quadralivre.quadra_agendamentos_api.enums.UserRole;
import com.quadralivre.quadra_agendamentos_api.mappers.athleteMapper.AthleteMapper;
import com.quadralivre.quadra_agendamentos_api.mappers.userMapper.UserMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.athlete.AthleteRepository;
import com.quadralivre.quadra_agendamentos_api.repositories.user.UserRepository;
import com.quadralivre.quadra_agendamentos_api.services.athleteService.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = new User();
        userMapper.createEntityFromDto(userDto, user);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateEntityFromDto(userDto, user);
        userRepository.save(user);
        return userMapper.toDto(user);


    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
