package com.quadralivre.quadra_agendamentos_api.dtos.usersDtos;

import com.quadralivre.quadra_agendamentos_api.enums.UserRole;

public record UserRequestDto(

        String name,
        String surname,
        String imgUrl,
        String cpf,
        String username,
        String password,
        String email,
        String phone,
        UserRole role

) {
}
