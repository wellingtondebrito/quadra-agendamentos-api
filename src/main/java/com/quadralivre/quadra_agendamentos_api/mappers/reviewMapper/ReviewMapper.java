package com.quadralivre.quadra_agendamentos_api.mappers.reviewMapper;




import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.reviewDtos.ReviewResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.review.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {

   ReviewResponseDto toDto(Review review);

   Review toEntity(ReviewRequestDto dto);

   default List<ReviewResponseDto> toDtoListByAthlete(Long athleteId, List<Review> reviews){
         return reviews.stream()
                .filter(review -> review.getAthlete() != null && review.getAthlete().getId().equals(athleteId))
                .map(this::toDto)
                .toList();
   }

    default List<ReviewResponseDto> toDtoListBySportCourt(Long sportCourtId, List<Review> reviews){
            return reviews.stream()
                 .filter(review -> review.getSportsCourt() != null && review.getSportsCourt().getId().equals(sportCourtId))
                 .map(this::toDto)
                 .toList();
    }

    void createEntityFromDto(ReviewRequestDto dto, @MappingTarget Review review);


}
