package com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleRequestDto(

        String date,
        String time,
        String status,
        int duration,
        BigDecimal priceTotal,
        int qtdAthletes,
        Long athleteId,
        Long sportCourtId,
        LocalDate createdAt
) {
}
