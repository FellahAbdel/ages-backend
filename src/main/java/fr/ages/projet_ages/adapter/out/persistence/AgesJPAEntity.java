package fr.ages.projet_ages.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ages")
@AllArgsConstructor
@NoArgsConstructor
public class AgesJPAEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Titre", length = 50, nullable = false, unique = false)
    private String titre;

    @Column(name = "Descrition", length = 500, nullable = false, unique = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
