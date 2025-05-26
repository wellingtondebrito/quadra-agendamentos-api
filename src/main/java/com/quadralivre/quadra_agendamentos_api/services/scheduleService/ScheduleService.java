package com.quadralivre.quadra_agendamentos_api.services.scheduleService;

import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleService {

    List<ScheduleResponseDto> findAllSchedules();
    ScheduleResponseDto findScheduleById(Long id);
    ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleDto);
    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleDto);
    void deleteSchedule(Long id);
}
