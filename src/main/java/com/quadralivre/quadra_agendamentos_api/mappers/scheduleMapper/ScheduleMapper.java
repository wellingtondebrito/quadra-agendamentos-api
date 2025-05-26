package com.quadralivre.quadra_agendamentos_api.mappers.scheduleMapper;





import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScheduleMapper {

    ScheduleResponseDto toDto(Schedule schedule);

    List<ScheduleResponseDto> toDtoList(List<Schedule> schedules);

    Schedule toEntity(ScheduleRequestDto dto);
    void createEntityFromDto(ScheduleRequestDto dto, @MappingTarget Schedule schedule);

    void updateEntityFromDto(ScheduleRequestDto dto, @MappingTarget Schedule schedule);

}
