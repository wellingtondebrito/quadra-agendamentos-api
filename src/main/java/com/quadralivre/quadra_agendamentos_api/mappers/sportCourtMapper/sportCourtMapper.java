package com.quadralivre.quadra_agendamentos_api.mappers.sportCourtMapper;






import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface sportCourtMapper {

    SportsCourtResponseDto toDto(SportCourt sportCourt);

    List<SportsCourtResponseDto> toDtoList(List<SportCourt> sportCourts);

    SportCourt toEntity(SportsCourtRequestDto dto);

    void updateEntityFromDto(SportsCourtRequestDto dto, @MappingTarget SportCourt sportCourt);

}
