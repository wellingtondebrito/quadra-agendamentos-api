package com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleResponseDto (
        Long id,
        LocalDate date,
        LocalTime time,
        String status,
        int duration,
        BigDecimal priceTotal,
        int qtdAthletes,
        AthleteResponseDto athlete,
        SportsCourtResponseDto sportCourt,
        LocalDate createdAt
) {
}
