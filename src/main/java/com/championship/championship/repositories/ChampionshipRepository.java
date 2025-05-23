package com.championship.championship.repositories;

import com.championship.championship.entities.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipRepository extends JpaRepository<TeamModel, Long> {
}
