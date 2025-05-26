package com.quadralivre.quadra_agendamentos_api.controllers.scheduleController;


import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.scheduleDtos.ScheduleResponseDto;
import com.quadralivre.quadra_agendamentos_api.services.scheduleService.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        List<ScheduleResponseDto> schedules = scheduleService.findAllSchedules();
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleDto) {
        ScheduleResponseDto createdSchedule = scheduleService.createSchedule(scheduleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleDto) {
        ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(id, scheduleDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSchedule);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
