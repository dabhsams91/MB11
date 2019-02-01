package com.mb11.application.service.sport;

import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Series;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntitySportAPIServiceTest {

	@Autowired
	EntitySportAPIService es;
	
	@Autowired
	SeriesRepository sr;
	
	@Autowired
	MTeamRepository mtr;
	
	@Autowired
	MatchRepository mr;
	
	@Test
	public void getSeriesAndTeams() throws JSONException, ParseException
	{
		
		List<Series> ls=es.getSeriesAndTeams("201819");
		sr.saveAll(ls);
	}

	@Test
	public void getSeries() throws JSONException, ParseException
	{
		List<Series> ls=es.getSeries("201819");
		sr.saveAll(ls);
		
	}
	
	@Test
	public void getTeams()
	{
		List<MTeam> mt=es.getTeams(111297L);
		mtr.saveAll(mt);
	}
	
	@Test
	public void getMatches() throws JSONException, ParseException
	{
		es.getMatches(111297L);
	}
	
	/**
	 * Gets the team players.
	 *
	 * @return the team players
	 */
	@Test
	public void getTeamPlayers()
	{
		es.getTeamPlayers(111297L);
	}
	
	
	
	
	
}
