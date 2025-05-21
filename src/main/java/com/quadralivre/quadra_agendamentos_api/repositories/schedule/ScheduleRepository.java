package com.quadralivre.quadra_agendamentos_api.repositories.schedule;

import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
