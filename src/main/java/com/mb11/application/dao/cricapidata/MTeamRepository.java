package com.mb11.application.dao.cricapidata;


import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mb11.application.model.cricapidata.MTeam;


@Repository
public interface MTeamRepository extends JpaRepository<MTeam, Long>{

	public MTeam findByTeamid(Long teamId);
	
	@Query(value = "SELECT * FROM MTeam WHERE series = ?1", nativeQuery = true)
	  public Set<MTeam> findMatchBySeriesId(String seriesid);
}
