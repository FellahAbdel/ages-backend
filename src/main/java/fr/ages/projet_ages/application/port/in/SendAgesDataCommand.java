package fr.ages.projet_ages.application.port.in;

import jakarta.validation.constraints.NotNull;

import static fr.ages.projet_ages.common.validation.Validation.validate;

public record SendAgesDataCommand(@NotNull String titre, @NotNull String description, @NotNull String objectif) {
    public SendAgesDataCommand (String titre, String description, String objectif) {
        this.titre = titre;
        this.description = description;
        this.objectif = objectif;
        validate(this);
    }
}
