package com.mb11.application.dao.cricapidata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.MTeam;

@Repository
public interface MTeamRepository extends JpaRepository<MTeam, Long>{

	public MTeam findByTeamid(Long teamId);
}
