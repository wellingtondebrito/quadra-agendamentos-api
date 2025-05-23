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

    List<ReviewResponseDto> toDtoList(List<Review> reviews);

    Review toEntity(ReviewRequestDto dto);

    void updateEntityFromDto(ReviewRequestDto dto, @MappingTarget Review review);

}
