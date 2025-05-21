package com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos;

import com.quadralivre.quadra_agendamentos_api.dtos.shceduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.review.Review;

import java.util.List;

public record AthleteResponseDto(
        Long id,
        String name,
        String surname,
        String imgUrl,
        String cpf,
        String username,
        String email,
        String phone,
        List<ScheduleResponseDto> schedules,
        List<Review> reviews,
        String role
) {
}
