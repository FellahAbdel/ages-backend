package fr.ages.projet_ages.application.port.in;

import jakarta.validation.constraints.NotNull;

import static fr.ages.projet_ages.common.validation.Validation.validate;

public record SendAgesDataCommand(@NotNull String titre, @NotNull String desc) {
    public SendAgesDataCommand (String titre, String desc) {
        this.titre = titre;
        this.desc = desc;
        validate(this);
    }
}
