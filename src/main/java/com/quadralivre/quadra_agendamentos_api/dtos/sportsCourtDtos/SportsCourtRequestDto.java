package com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SportsCourtRequestDto(

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
        Long ownerId,
        String rules,
        String paymentMethods

) {
}
