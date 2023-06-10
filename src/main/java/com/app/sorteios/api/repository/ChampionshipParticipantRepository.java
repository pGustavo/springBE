package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.ChampionshipParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipParticipantRepository extends JpaRepository<ChampionshipParticipant, Long> {
}