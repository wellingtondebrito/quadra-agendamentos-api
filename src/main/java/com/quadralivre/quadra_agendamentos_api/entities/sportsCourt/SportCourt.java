package com.quadralivre.quadra_agendamentos_api.entities.sportsCourt;

import com.quadralivre.quadra_agendamentos_api.entities.owner.Owner;
import com.quadralivre.quadra_agendamentos_api.entities.review.Review;
import com.quadralivre.quadra_agendamentos_api.entities.schedule.Schedule;
import com.quadralivre.quadra_agendamentos_api.enums.StatusRole;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sport_courts")
public class SportCourt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String cnpj;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String type; // Enum tipo de quadra (Futebol, Basquete, etc)
    private StatusRole status; // Enum status (Disponível, Ocupada, etc)
    private String imageUrl; // URL da imagem da quadra
    @Column(nullable = false)
    private String phone;
    private String email;
    private String website;
    private String openingHours; // Horário de funcionamento
    private BigDecimal price; // Preço por hora ou por uso
    private String amenities; // Amenidades disponíveis (banheiros, vestiários, etc)
    private String location; // Localização geográfica (latitude, longitude)


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
    // Proprietário da quadra
    private String rules;
    // Regras de uso da quadra
    private String paymentMethods;
    // Métodos de pagamento aceitos
    @OneToMany(mappedBy = "sportsCourt", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @OneToMany(mappedBy = "sportCourt", cascade = CascadeType.ALL, orphanRemoval = true)
    // Relacionamento com a entidade Schedule
    private List<Schedule> schedules = new ArrayList<>();
    // Lista de agendamentos associados à quadra
    private LocalDateTime createdAt;

}
