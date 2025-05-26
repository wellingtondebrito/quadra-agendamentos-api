package com.quadralivre.quadra_agendamentos_api.services.scheduleService;


import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.mappers.scheduleMapper.ScheduleMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.schedule.ScheduleRepository;
import com.quadralivre.quadra_agendamentos_api.services.athleteService.AthleteService;
import com.quadralivre.quadra_agendamentos_api.services.sportCourtSevice.SportCourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final AthleteService athleteService;
    private final SportCourtService sportCourtService;

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return scheduleMapper.toDtoList(schedules);
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with id: " + id));
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleDto) {

        Schedule schedule = new Schedule();

        if(scheduleDto.athleteId() == null || scheduleDto.sportCourtId() == null) {
            throw new IllegalArgumentException("Athlete ID and Sport Court ID cannot be null");
        }

        Athlete athlete = athleteService.getAthleteByIdEntity(scheduleDto.athleteId());
        SportCourt sportCourt = sportCourtService.getSportCourtByIdEntity(scheduleDto.sportCourtId());

        LocalDate date = LocalDate.parse(scheduleDto.date());
        LocalTime time = LocalTime.parse(scheduleDto.time());
        LocalDateTime createdAt = LocalDateTime.now();

        if(date.isBefore(LocalDate.now()) || time.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("Date and time must be in the future");
        }
        schedule.setAthlete(athlete);
        schedule.setSportCourt(sportCourt);
        schedule.setCreatedAt(createdAt);
        schedule.setDate(date);
        schedule.setTime(time);
        scheduleMapper.createEntityFromDto(scheduleDto, schedule);
        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);


    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with id: " + id));

        if(scheduleDto.athleteId() != null) {
            Athlete athlete = athleteService.getAthleteByIdEntity(scheduleDto.athleteId());
            schedule.setAthlete(athlete);
        }

        if(scheduleDto.sportCourtId() != null) {
            SportCourt sportCourt = sportCourtService.getSportCourtByIdEntity(scheduleDto.sportCourtId());
            schedule.setSportCourt(sportCourt);
        }

        LocalDate date = LocalDate.parse(scheduleDto.date());
        LocalTime time = LocalTime.parse(scheduleDto.time());


        if(date.isBefore(LocalDate.now()) || time.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("Date and time must be in the future");
        }

        schedule.setDate(date);
        schedule.setTime(time);
        scheduleMapper.updateEntityFromDto(scheduleDto, schedule);
        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with id: " + id));
        scheduleRepository.delete(schedule);

    }

}
