package com.mb11.application.dao.cricapidata;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mb11.application.model.cricapidata.Match;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long>
{
	public Match findByMatchid(Long matchid);
	
	@Query(value = "SELECT * FROM MATCH WHERE sid = ?1", nativeQuery = true)
	  public List<Match> findMatchBySeriesId(String seriesid);
}
