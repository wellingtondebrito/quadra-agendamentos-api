package com.quadralivre.quadra_agendamentos_api.entities.owner;

import com.quadralivre.quadra_agendamentos_api.entities.sportsCourt.SportCourt;
import com.quadralivre.quadra_agendamentos_api.entities.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@PrimaryKeyJoinColumn
@DiscriminatorValue("owners")
@Table(name = "owners")
public class Owner extends User {


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SportCourt> sportCourts = new ArrayList<>();

}
