package com.quadralivre.quadra_agendamentos_api.repositories.review;

import com.quadralivre.quadra_agendamentos_api.entities.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
