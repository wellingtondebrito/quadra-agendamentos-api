package com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos;

import com.quadralivre.quadra_agendamentos_api.enums.UserRole;

public record AthleteRequestDto(

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
