package com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos;

import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.enums.UserRole;

import java.util.List;

public record OwnerRequestDto(

        String name,
        String surname,
        String imgUrl,
        String cpf,
        String username,
        String password,
        String email,
        String phone,
        List<SportCourt> sportCourts,
        UserRole role

) {
}
