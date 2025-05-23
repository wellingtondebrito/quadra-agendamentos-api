package com.quadralivre.quadra_agendamentos_api.repositories.owner;

import com.quadralivre.quadra_agendamentos_api.entities.owner.Owner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
