package com.mb11.application.service.sport;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.MatchTeamLinkRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.dao.cricapidata.SeriesTeamPlayerRepository;
import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.MatchTeamLink;
import com.mb11.application.model.cricapidata.Series;
import com.mb11.application.model.cricapidata.SeriesTeamPlayer;
import com.mb11.application.model.cricapidata.TeamPlayers;

public class CricSportSyncService {

	@Autowired
	EntitySportAPIService entitySportAPIService;

	@Autowired
	SeriesRepository seriesRepository;

	@Autowired
	MTeamRepository mTeamRepository;

	@Autowired
	MatchRepository matchRepository;

	@Autowired
	TeamPlayersRepository playersRepository;

	@Autowired
	SeriesTeamPlayerRepository seriesTeamPlayerRepository;

	@Autowired
	MatchTeamLinkRepository matchTeamLinkRepository;

	@Transactional
	public List<Series> saveUpdateSeries(List<Series> series) {
		return seriesRepository.saveAll(series);
	}
	
	@Transactional
	public List<Match> saveUpdateMatch(List<Match> matchs) {
		return matchRepository.saveAll(matchs);
	}
	
	@Transactional
	public List<MTeam> saveUpdateMTeam(List<MTeam> mTeams) {
		return mTeamRepository.saveAll(mTeams);
	}
	
	@Transactional
	public List<TeamPlayers> saveUpdateTeamPlayers(List<TeamPlayers> teamPlayers) {
		return playersRepository.saveAll(teamPlayers);
	}

	@Transactional
	public void saveUpdateMatchTeamLink(List<MTeam> mTeams, Match match) {

		if (mTeams != null && mTeams.size() > 0 && match != null) {
			List<MatchTeamLink> matchTeamLinks = new ArrayList<>();
			for (MTeam mTeam : mTeams) {

				MatchTeamLink matchTeamLink = new MatchTeamLink();
				matchTeamLink.setMatchid(match);
				matchTeamLink.setTeamid(mTeam);
				matchTeamLinks.add(matchTeamLink);
			}
			matchTeamLinkRepository.saveAll(matchTeamLinks);
		}
	}

	@Transactional
	public void saveUpdateSeriesTeamPlayers(List<TeamPlayers> teamPlayers, Series series) {

		if (teamPlayers != null && teamPlayers.size() > 0 && series != null) {
			List<SeriesTeamPlayer> seriesTeamPlayers = new ArrayList<>();
			for (TeamPlayers players : teamPlayers) {

				SeriesTeamPlayer seriesTeamPlayer = new SeriesTeamPlayer();
				seriesTeamPlayer.setSid(series);
				seriesTeamPlayer.setTpid(players);
				seriesTeamPlayers.add(seriesTeamPlayer);
			}
			seriesTeamPlayerRepository.saveAll(seriesTeamPlayers);
		}

	}

}
