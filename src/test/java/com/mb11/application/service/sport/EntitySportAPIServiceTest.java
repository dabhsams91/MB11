package com.mb11.application.service.sport;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.Series;
import com.mb11.application.model.cricapidata.TeamPlayers;

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

	@Autowired
	TeamPlayersRepository tpr;

	@Test
	public void getSeriesAndTeams() throws JSONException, ParseException {

		List<Series> ls = es.getSeries("201819");
		if (ls != null) {
			List<Series> persistedSeries = sr.saveAll(ls);

			for (Series series : persistedSeries) {

				Set<MTeam> mt = es.getTeams(series.getSeriesid());

				if (mt != null) {
					List<MTeam> persistedTeams = mtr.saveAll(mt);
				}

				List<Match> matches = es.getMatches(series.getSeriesid());

				if (matches != null) {
					List<Match> persistedMatch = mr.saveAll(matches);
				}

				List<TeamPlayers> teamPlayes = es.getTeamPlayers(series.getSeriesid());

				if (teamPlayes != null) {
					List<TeamPlayers> persistedTeamPlayes = tpr.saveAll(teamPlayes);
				}
			}
		}

	}

}
