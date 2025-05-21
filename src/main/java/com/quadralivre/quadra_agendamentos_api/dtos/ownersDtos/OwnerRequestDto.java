package com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos;

import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;

import java.util.List;

public record OwnerRequestDto(

        String name,
        String surname,
        String imgUrl,
        String cpf,
        String username,
        String email,
        String phone,
        List<SportCourt> sportCourts,
        String role

) {
}
