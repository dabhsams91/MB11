package com.mb11.application.service.sport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.MatchTeamLinkRepository;
import com.mb11.application.dao.cricapidata.PlayerCreditRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.dao.cricapidata.SeriesTeamPlayerRepository;
import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.MatchTeamLink;
import com.mb11.application.model.cricapidata.PlayerCredit;
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

	@Autowired
	PlayerCreditRepository playerCreditRepository;

	@Transactional
	public List<Series> saveUpdateSeries(List<Series> series) {
		return seriesRepository.saveAll(series);
	}

	@Transactional
	public List<Match> saveUpdateMatch(List<Match> matches) {
		return matchRepository.saveAll(matches);
	}

	@Transactional
	public List<MTeam> saveUpdateMTeam(Set<MTeam> mTeams) {
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

	@Transactional
	public void syncSeriesTeamsMatchAndPlayers(String duration) {

		List<Series> ls = entitySportAPIService.getSeries(duration);
		if (ls != null) {
			List<Series> persistedSeries = saveUpdateSeries(ls);

			for (Series series : persistedSeries) {

				Set<MTeam> mt = entitySportAPIService.getTeams(series.getSeriesid());

				List<MTeam> persistedTeams = null;

				if (mt != null) {
					persistedTeams = saveUpdateMTeam(mt);

				}
				List<Match> matches = entitySportAPIService.getMatches(series.getSeriesid());

				List<Match> persistedMatch = null;

				if (matches != null) {
					persistedMatch = saveUpdateMatch(matches);

					if (persistedMatch != null) {
						for (Match match : persistedMatch) {

							if (!persistedTeams.isEmpty()) {
								saveUpdateMatchTeamLink(persistedTeams, match);
							}
						}

					}
				}
				List<TeamPlayers> teamPlayes = entitySportAPIService.getTeamPlayers(series.getSeriesid());

				if (teamPlayes != null) {
					List<TeamPlayers> persistedTeamPlayes = saveUpdateTeamPlayers(teamPlayes);
					saveUpdateSeriesTeamPlayers(persistedTeamPlayes, series);
				}
			}
		}

	}

	@Transactional
	public List<PlayerCredit> saveUpdateSeriesTeamPlayers(List<PlayerCredit> playerCredits) {

		return playerCreditRepository.saveAll(playerCredits);

	}

}
