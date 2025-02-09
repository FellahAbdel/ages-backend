package fr.ages.projet_ages.application.port.out;

import fr.ages.projet_ages.application.domain.model.Ages;

public interface WriteAgesDataPort {
    boolean writeAgesData(Ages ages);
}
