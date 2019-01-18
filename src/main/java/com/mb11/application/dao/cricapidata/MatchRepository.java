package com.mb11.application.dao.cricapidata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb11.application.model.cricapidata.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

}
