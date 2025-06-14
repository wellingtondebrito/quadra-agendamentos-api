package com.quadralivre.quadra_agendamentos_api.entities.athlete;

import com.quadralivre.quadra_agendamentos_api.entities.review.Review;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@PrimaryKeyJoinColumn
@DiscriminatorValue("athletes")
@Table(name = "athletes")
public class Athlete extends User {


    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
