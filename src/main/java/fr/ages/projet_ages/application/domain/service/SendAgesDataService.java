package fr.ages.projet_ages.application.domain.service;

import fr.ages.projet_ages.application.domain.model.Ages;
import fr.ages.projet_ages.application.port.in.SendAgesDataCommand;
import fr.ages.projet_ages.application.port.in.SendAgesDataUseCase;
import fr.ages.projet_ages.application.port.out.WriteAgesDataPort;
import fr.ages.projet_ages.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SendAgesDataService implements SendAgesDataUseCase {
    private final WriteAgesDataPort writeAgesDataPort;

    @Override
    public boolean sendAgesData(SendAgesDataCommand command) {
        Ages agesData = new Ages();
        agesData.setTitre(command.titre());
        agesData.setDescription(command.description());
        agesData.setObjectif(command.objectif());
        writeAgesDataPort.writeAgesData(agesData);
        return false;
    }
}
