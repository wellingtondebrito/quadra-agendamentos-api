package com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;

import java.time.LocalDateTime;

public record ReviewRequestDto(

        int rating,
        String comments,
        Long athleteId,
        Long sportCourtId
) {
}
