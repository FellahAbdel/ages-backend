package fr.ages.projet_ages.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AgesRepository extends JpaRepository<AgesJPAEntity, Long> {
    @Modifying
    @Query("update AgesJPAEntity a set a.titre = ?1, a.description = ?2, a.objectif = ?3 where a.id = ?4")
    void setAgesDataById(String titre, String desc, String objectif, Long agesId);
}
