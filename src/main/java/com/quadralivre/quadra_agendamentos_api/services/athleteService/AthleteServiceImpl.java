package com.quadralivre.quadra_agendamentos_api.services.athleteService;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.usersDtos.UserResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import com.quadralivre.quadra_agendamentos_api.mappers.athleteMapper.AthleteMapper;
import com.quadralivre.quadra_agendamentos_api.mappers.userMapper.UserMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.athlete.AthleteRepository;
import com.quadralivre.quadra_agendamentos_api.repositories.user.UserRepository;
import com.quadralivre.quadra_agendamentos_api.services.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteServiceImpl implements AthleteService {

    private final AthleteRepository athleteRepository;
    private final AthleteMapper athleteMapper;



    @Override
    public AthleteResponseDto createAthlete(AthleteRequestDto dto) {
        Athlete athlete = new Athlete();
        athleteMapper.createEntityFromDto(dto, athlete);
        athleteRepository.save(athlete);
        return athleteMapper.toDto(athlete);

    }

    @Override
    public List<AthleteResponseDto> getAllAthlete() {
        List<Athlete> athletes = athleteRepository.findAll();
        return athleteMapper.toDtoList(athletes);
    }

    @Override
    public AthleteResponseDto getAthleteById(Long id) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
        return athleteMapper.toDto(athlete);
    }

    @Override
    public AthleteResponseDto updateAthlete(Long id, AthleteRequestDto dto) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
        athleteMapper.updateEntityFromDto(dto, athlete);
        athleteRepository.save(athlete);
        return athleteMapper.toDto(athlete);
    }

    @Override
    public void deleteAthlete(Long id) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
        athleteRepository.delete(athlete);

    }
}
