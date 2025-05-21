package com.quadralivre.quadra_agendamentos_api.mappers.athleteMapper;



import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AthleteMapper {

   AthleteResponseDto toDto(Athlete athlete);

    List<AthleteResponseDto> toDtoList(List<Athlete> athletes);

    Athlete toEntity(AthleteRequestDto dto);

    void updateEntityFromDto(AthleteRequestDto dto, @MappingTarget Athlete athlete);

}
