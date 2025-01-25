package fr.ages.projet_ages.adapter.out.persistence;

import fr.ages.projet_ages.application.domain.model.Ages;
import org.springframework.stereotype.Component;

@Component
public class AgesMapper {
    Ages mapToDomainEntity(AgesJPAEntity ages){
        Ages domainEntity = new Ages();
        domainEntity.setId(ages.getId());
        domainEntity.setTitre(ages.getTitre());
        domainEntity.setDescription(ages.getDescription());
        return domainEntity;
    }

    AgesJPAEntity mapToJpaEntity(Ages ages){
        AgesJPAEntity jpaDomainEntity = new AgesJPAEntity();
        jpaDomainEntity.setId(ages.getId());
        jpaDomainEntity.setTitre(ages.getTitre());
        jpaDomainEntity.setDescription(ages.getDescription());
        return jpaDomainEntity;
    }
}
