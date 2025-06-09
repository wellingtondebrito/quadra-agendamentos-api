package com.quadralivre.quadra_agendamentos_api.mappers.userMapper;



import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User createEntityFromDto(UserRequestDto userDto);

    UserResponseDto toDto(User user);

    List<UserResponseDto> toDtoList(List<User> users);

    void updateEntityFromDto(UserRequestDto userDto, @MappingTarget User user);

}
