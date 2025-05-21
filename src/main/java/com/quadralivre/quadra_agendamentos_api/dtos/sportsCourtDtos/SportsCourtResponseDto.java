package com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos;

import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.shceduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.review.Review;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SportsCourtResponseDto(
        Long id,
        String name,
        String cnpj,
        String address,
        String city,
        String state,
        String zipCode,
        String neighborhood,
        String description,
        String type,
        String status,
        String imageUrl,
        String phone,
        String email,
        String website,
        String openingHours,
        BigDecimal price,
        String amenities,
        String location,
        OwnerResponseDto owner,
        String rules,
        String paymentMethods,
        List<ScheduleResponseDto> schedules,
        List <Review> reviews,
        LocalDateTime createdAt
) {
}
