package com.quadralivre.quadra_agendamentos_api.services.reviewService;

import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewResponseDto;

import java.util.List;

public interface ReviewService {
    List<ReviewResponseDto> getAllReviewsAthlete(Long athleteId);
    List<ReviewResponseDto> getAllReviewsSportCourt(Long sportCourtId);
    ReviewResponseDto createReview(ReviewRequestDto reviewDto);
}
