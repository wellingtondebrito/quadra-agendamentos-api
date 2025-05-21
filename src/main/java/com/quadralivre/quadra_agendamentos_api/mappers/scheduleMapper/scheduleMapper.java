package com.quadralivre.quadra_agendamentos_api.mappers.scheduleMapper;





import com.quadralivre.quadra_agendamentos_api.dtos.shceduleDtos.ScheduleRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.shceduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface scheduleMapper {

    ScheduleResponseDto toDto(Schedule schedule);

    List<ScheduleResponseDto> toDtoList(List<Schedule> schedules);

    Schedule toEntity(ScheduleRequestDto dto);

    void updateEntityFromDto(ScheduleRequestDto dto, @MappingTarget Schedule schedule);

}
