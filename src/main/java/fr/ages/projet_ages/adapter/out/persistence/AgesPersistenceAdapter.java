package fr.ages.projet_ages.adapter.out.persistence;

import fr.ages.projet_ages.application.domain.model.Ages;
import fr.ages.projet_ages.application.port.out.LoadAgesDataPort;
import fr.ages.projet_ages.application.port.out.UpdateAgesDataPort;
import fr.ages.projet_ages.application.port.out.WriteAgesDataPort;
import fr.ages.projet_ages.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class AgesPersistenceAdapter implements WriteAgesDataPort, LoadAgesDataPort, UpdateAgesDataPort {
    private final AgesRepository agesRepository;
    private final AgesMapper agesMapper;

    @Override
    public boolean writeAgesData(Ages ages) {
        try {
            agesRepository.save(agesMapper.mapToJpaEntity(ages));
            return true;
        } catch (DataIntegrityViolationException e) {
            System.err.println("Data integrity violation: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Ages loadAgesData(Long id) {
        Optional<AgesJPAEntity> agesJpaEntity = agesRepository.findById(id);
        return agesJpaEntity.map(agesMapper::mapToDomainEntity).orElse(null);
    }

    @Override
    public boolean updateAgesData(Ages ages) {
        try {
            agesRepository.setAgesDataById(ages.getTitre(), ages.getDescription(), ages.getObjectif(), ages.getId());
            return true;
        } catch (DataIntegrityViolationException e) {
            System.err.println("Data integrity violation: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
            return false;
        }
    }
}
