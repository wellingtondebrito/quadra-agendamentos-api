package com.quadralivre.quadra_agendamentos_api.entities.schedule;


import com.quadralivre.quadra_agendamentos_api.entities.athlete.Athlete;
import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.enums.StatusRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Enumerated(EnumType.STRING)
    private StatusRole status; // Enum status

    @Column(nullable = false)
    private int duration; // duração em minutos

    @Column(precision = 10, scale = 2, nullable = false, name = "price")
    private BigDecimal priceTotal; // preço do agendamento

    @Column(nullable = false, name = "qtd_athletes")
    private int qtdAthletes; // quantidade de atletas

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete; // atleta que agendou a quadra

    @ManyToOne
    @JoinColumn(name = "sport_court_id", nullable = false)
    private SportCourt sportCourt; // a quadra agendada.

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
