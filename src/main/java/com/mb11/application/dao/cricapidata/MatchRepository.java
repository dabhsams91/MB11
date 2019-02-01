package com.mb11.application.dao.cricapidata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>
{

}
