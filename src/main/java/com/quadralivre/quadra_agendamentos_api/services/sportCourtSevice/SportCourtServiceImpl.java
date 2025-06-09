package com.quadralivre.quadra_agendamentos_api.services.sportCourtSevice;

import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.owner.Owner;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.mappers.sportCourtMapper.SportCourtMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.sportCourt.SportCourtRepository;
import com.quadralivre.quadra_agendamentos_api.services.ownerService.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SportCourtServiceImpl implements SportCourtService {

    private final SportCourtRepository sportCourtRepository;
    private final SportCourtMapper sportCourtMapper;
    private final OwnerService ownerService;

    @Override
    public SportsCourtResponseDto createSportCourt(SportsCourtRequestDto sportsCourtDto) {
        SportCourt sportCourt = new SportCourt();

        if(sportsCourtDto.ownerId() == null) {
            throw new IllegalArgumentException("Owner ID cannot be null");
        }

        Owner owner = ownerService.getOwnerByIdEntity(sportsCourtDto.ownerId());

        sportCourt.setCreatedAt(LocalDateTime.now());
        sportCourt.setOwner(owner);
        sportCourtMapper.createEntityFromDto(sportsCourtDto, sportCourt);
        sportCourtRepository.save(sportCourt);
        return sportCourtMapper.toDto(sportCourt);

    }

    @Override
    public List<SportsCourtResponseDto> getAllSportsCourts() {
        List<SportCourt> sportCourts = sportCourtRepository.findAll();
        return sportCourtMapper.toDtoList(sportCourts);
    }

    @Override
    public SportsCourtResponseDto getSportCourtById(Long id) {
        SportCourt sportCourt = sportCourtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sport Court not found with id: " + id));
        return sportCourtMapper.toDto(sportCourt);
    }

    @Override
    public SportsCourtResponseDto updateSportCourt(Long id, SportsCourtRequestDto sportsCourtDto) {
        SportCourt sportCourt = sportCourtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sport Court not found with id: " + id));

        if(sportsCourtDto.ownerId() == null) {
            throw new IllegalArgumentException("Owner ID cannot be null");
        }

        Owner owner = ownerService.getOwnerByIdEntity(sportsCourtDto.ownerId());

        sportCourt.setOwner(owner);
        sportCourtMapper.updateEntityFromDto(sportsCourtDto, sportCourt);
        sportCourtRepository.save(sportCourt);
        return sportCourtMapper.toDto(sportCourt);

    }

    @Override
    public void deleteSportCourt(Long id) {
        SportCourt sportCourt = sportCourtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sport Court not found with id: " + id));
        sportCourtRepository.delete(sportCourt);

    }

    @Override
    public SportCourt getSportCourtByIdEntity(Long id) {
        return sportCourtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sport Court not found with id: " + id));
    }
}
