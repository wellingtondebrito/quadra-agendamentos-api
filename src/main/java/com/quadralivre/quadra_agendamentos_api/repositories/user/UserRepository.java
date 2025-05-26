package com.quadralivre.quadra_agendamentos_api.repositories.user;

import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
