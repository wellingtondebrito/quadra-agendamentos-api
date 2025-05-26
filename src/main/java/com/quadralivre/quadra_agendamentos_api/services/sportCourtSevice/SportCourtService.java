package com.quadralivre.quadra_agendamentos_api.services.sportCourtSevice;

import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;

import java.util.List;

public interface SportCourtService {
    SportsCourtResponseDto createSportCourt(SportsCourtRequestDto sportsCourtDto);
    List<SportsCourtResponseDto> getAllSportsCourts();
    SportsCourtResponseDto getSportCourtById(Long id);
    SportsCourtResponseDto updateSportCourt(Long id, SportsCourtRequestDto sportsCourtDto);
    void deleteSportCourt(Long id);
    SportCourt getSportCourtByIdEntity(Long id);

}
