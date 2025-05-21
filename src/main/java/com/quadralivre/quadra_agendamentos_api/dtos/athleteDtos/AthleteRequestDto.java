package com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos;

public record AthleteRequestDto(

        String name,
        String surname,
        String imgUrl,
        String cpf,
        String username,
        String email,
        String phone,
        String role

) {
}
