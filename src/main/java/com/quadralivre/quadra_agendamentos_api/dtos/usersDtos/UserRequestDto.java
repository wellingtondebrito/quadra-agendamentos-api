package com.quadralivre.quadra_agendamentos_api.dtos.usersDtos;

public record UserRequestDto(

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
