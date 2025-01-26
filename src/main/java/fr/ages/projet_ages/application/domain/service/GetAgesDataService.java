package fr.ages.projet_ages.application.domain.service;

import fr.ages.projet_ages.application.domain.model.Ages;
import fr.ages.projet_ages.application.port.in.GetAgesDataUseCase;
import fr.ages.projet_ages.application.port.out.LoadAgesDataPort;
import fr.ages.projet_ages.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetAgesDataService implements GetAgesDataUseCase {
    private final LoadAgesDataPort loadAgesDataPort;

    @Override
    public Ages getAgesData(Long id) {
        return loadAgesDataPort.loadAgesData(id);
    }
}
