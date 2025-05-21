package com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;

import java.time.LocalDateTime;

public record ReviewResponseDto(
        Long id,
        int rating,
        String comments,
        LocalDateTime avaliationDate,
        AthleteResponseDto athlete,
        SportsCourtResponseDto sportCourt
) {
}
