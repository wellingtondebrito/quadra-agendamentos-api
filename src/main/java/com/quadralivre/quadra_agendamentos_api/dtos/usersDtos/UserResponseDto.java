package com.quadralivre.quadra_agendamentos_api.dtos.usersDtos;

public record UserResponseDto(
        Long id,
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
