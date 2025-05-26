package com.quadralivre.quadra_agendamentos_api.services.athleteService;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;

import java.util.List;

public interface AthleteService {
    AthleteResponseDto createAthlete(AthleteRequestDto dto);
    List<AthleteResponseDto> getAllAthlete();
    AthleteResponseDto getAthleteById(Long id);
    AthleteResponseDto updateAthlete(Long id, AthleteRequestDto dto);
    void deleteAthlete(Long id);

    Athlete getAthleteByIdEntity(Long id);
}
