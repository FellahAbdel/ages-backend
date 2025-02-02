package fr.ages.projet_ages.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ages")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgesJPAEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Titre", length = 50, nullable = false, unique = false)
    private String titre;

    @Column(name = "Descrition", length = 500, nullable = false, unique = false)
    private String description;

    @Column(name = "Objectif", length = 500, nullable = false, unique = false)
    private String objectif;
}
