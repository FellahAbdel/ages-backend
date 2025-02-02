package fr.ages.projet_ages.application.domain.model;

import lombok.Data;

@Data
public class Ages {
    private Long id;
    private String titre;
    private String description;
    private String objectif;
}
