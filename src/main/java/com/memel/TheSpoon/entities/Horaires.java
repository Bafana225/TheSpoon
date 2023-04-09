package com.memel.TheSpoon.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "horaires")
public class Horaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horaires")
    private Long id;
    @Column
    private String horaire;

    @OneToMany(mappedBy = "horaires", fetch = FetchType.LAZY, targetEntity = Reservation.class)
    @JsonIgnore
    private List<Reservation> reservations;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Horaires [id=").append(id)
                .append(", horaires=").append(horaire)
                .append("]\n");
        return sb.toString();
    }

}
