package com.quadralivre.quadra_agendamentos_api.entities.schedule;


import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    private LocalTime time;

    private String status; // Enum status

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete; // atleta que agendou a quadra

    @ManyToOne
    @JoinColumn(name = "sport_court_id", nullable = false)
    private SportCourt sportCourt; // a quadra agendada.

    // Add any additional fields or methods as needed
}
