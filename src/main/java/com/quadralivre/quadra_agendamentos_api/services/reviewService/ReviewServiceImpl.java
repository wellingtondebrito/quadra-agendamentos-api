package com.quadralivre.quadra_agendamentos_api.services.reviewService;


import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.review.Review;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.mappers.reviewMapper.ReviewMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.review.ReviewRepository;
import com.quadralivre.quadra_agendamentos_api.services.athleteService.AthleteService;
import com.quadralivre.quadra_agendamentos_api.services.sportCourtSevice.SportCourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final AthleteService athleteService;
    private final SportCourtService sportCourtService;

    @Override
    public List<ReviewResponseDto> getAllReviewsAthlete(Long athleteId) {
        //TODO: preciso validar se o usuário existe ou se não está nulo

        if (athleteId == null) {
            throw new IllegalArgumentException("Athlete ID cannot be null");
        }
        Athlete athlete = athleteService.getAthleteByIdEntity(athleteId);
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.toDtoListByAthlete(athlete.getId(), reviews);

    }

    @Override
    public List<ReviewResponseDto> getAllReviewsSportCourt(Long sportCourtId) {
        if (sportCourtId == null) {
            throw new IllegalArgumentException("Sport Court ID cannot be null");
        }
        SportCourt sportCourt = sportCourtService.getSportCourtByIdEntity(sportCourtId);
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.toDtoListBySportCourt(sportCourt.getId(), reviews);
    }

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto reviewDto) {
        //TODO: preciso validar se o usuário existe ou se não está nulo
       if(reviewDto.athleteId() == null || reviewDto.sportCourtId() == null) {
            throw new IllegalArgumentException("Athlete ID and Sport Court ID cannot be null");
        }

        Athlete athlete = athleteService.getAthleteByIdEntity(reviewDto.athleteId());
        SportCourt sportCourt = sportCourtService.getSportCourtByIdEntity(reviewDto.sportCourtId());

        Review review = new Review();
        reviewMapper.createEntityFromDto(reviewDto, review);
        review.setAthlete(athlete);
        review.setSportsCourt(sportCourt);

        reviewRepository.save(review);
        return reviewMapper.toDto(review);


    }
}
