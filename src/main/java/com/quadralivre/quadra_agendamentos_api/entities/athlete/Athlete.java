package com.quadralivre.quadra_agendamentos_api.entities.athlete;

import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "athletes")
public class Athlete extends User {

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();
}
