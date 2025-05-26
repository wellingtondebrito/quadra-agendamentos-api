package com.quadralivre.quadra_agendamentos_api.mappers.sportCourtMapper;






import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SportCourtMapper {

    SportsCourtResponseDto toDto(SportCourt sportCourt);

    List<SportsCourtResponseDto> toDtoList(List<SportCourt> sportCourts);

    void createEntityFromDto(SportsCourtRequestDto dto, @MappingTarget SportCourt sportCourt);

    SportCourt toEntity(SportsCourtRequestDto dto);

    void updateEntityFromDto(SportsCourtRequestDto dto, @MappingTarget SportCourt sportCourt);

}
