package fr.ages.projet_ages.adapter.out.persistence;

import fr.ages.projet_ages.application.domain.model.Ages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgesRepository extends JpaRepository<AgesJPAEntity, Long> {
}
