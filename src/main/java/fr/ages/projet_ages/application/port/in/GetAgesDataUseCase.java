package fr.ages.projet_ages.application.port.in;

import fr.ages.projet_ages.application.domain.model.Ages;

public interface GetAgesDataUseCase {
    Ages getAgesData(Long id);
}
