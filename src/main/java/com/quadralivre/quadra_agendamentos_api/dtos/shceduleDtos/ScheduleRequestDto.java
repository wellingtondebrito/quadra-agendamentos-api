package com.quadralivre.quadra_agendamentos_api.dtos.shceduleDtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleRequestDto(

        LocalDate date,
        LocalTime time,
        String status,
        int duration,
        BigDecimal priceTotal,
        int qtdAthletes,
        Long athleteId,
        Long sportCourtId,
        LocalDate createdAt
) {
}
