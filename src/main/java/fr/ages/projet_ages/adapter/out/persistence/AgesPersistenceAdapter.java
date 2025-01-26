package fr.ages.projet_ages.adapter.out.persistence;

import fr.ages.projet_ages.application.domain.model.Ages;
import fr.ages.projet_ages.application.port.out.LoadAgesDataPort;
import fr.ages.projet_ages.application.port.out.WriteAgesDataPort;
import fr.ages.projet_ages.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class AgesPersistenceAdapter implements WriteAgesDataPort, LoadAgesDataPort {
    private final AgesRepository agesRepository;
    private final AgesMapper agesMapper;

    @Override
    public void writeAgesData(Ages ages) {
            agesRepository.save(agesMapper.mapToJpaEntity(ages));
    }

    @Override
    public Ages loadAgesData(Long id) {
        Optional<AgesJPAEntity> agesJpaEntity = agesRepository.findById(id);
        return agesJpaEntity.map(agesMapper::mapToDomainEntity).orElse(null);
    }

}
