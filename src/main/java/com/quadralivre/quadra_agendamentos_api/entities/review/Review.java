package com.quadralivre.quadra_agendamentos_api.entities.review;

import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


    @Entity
    @Table(name = "reviews")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Review {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int rating; // 1 a 5

        private String comments;

        @CreationTimestamp
        private LocalDateTime avaliationDate;

        @ManyToOne
        @JoinColumn(name = "athlete_id")
        private Athlete athlete;

        @ManyToOne
        @JoinColumn(name = "sports_court_id")
        private SportCourt sportsCourt;
  }

