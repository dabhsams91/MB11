package com.mb11.application.dao.cricapidata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.MatchTeamLink;

@Repository
public interface MatchTeamLinkRepository extends JpaRepository<MatchTeamLink, Long>{

}
