package fr.ages.projet_ages.application.port.in;

public interface SendAgesDataUseCase {
    boolean sendAgesData(SendAgesDataCommand command);
    boolean sendAgesDataForUpdate(SendAgesDataCommand command);
}
