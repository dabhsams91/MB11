package com.mb11.application.repository.sport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.SeriesTeamPlayer;

@Repository
public interface SeriesTeamPlayerRepository extends JpaRepository<SeriesTeamPlayer, Long>{

}
