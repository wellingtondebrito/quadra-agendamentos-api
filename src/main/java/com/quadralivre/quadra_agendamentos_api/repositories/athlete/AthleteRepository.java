package com.quadralivre.quadra_agendamentos_api.repositories.athlete;

import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
