package com.mb11.application.sport.helper;

import org.springframework.stereotype.Service;

import com.mb11.application.config.RestTemplateConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class SportAPIHelper.
 */
@Service
public class SportAPIHelper {

	/** The competitions url. */
	private String competitionsUrl;

	/**
	 * Gets the series api.
	 *
	 * @param yearsPeriod the years period
	 * @return the series api
	 */
	public String getSeriesApi(String yearsPeriod) {
		competitionsUrl = "/seasons/" + yearsPeriod.trim() + "/competitions";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);
		return baseUrl.toString();
	}

	/**
	 * Gets the teams api.
	 *
	 * @param id the id
	 * @return the teams api
	 */
	public String getTeamsApi(Long id) {
		// https://rest.entitysport.com/v2/competitions/90534/teams?token=
		competitionsUrl = "/competitions/" + id + "/teams";

		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();
	}

	/**
	 * Gets the matches api.
	 *
	 * @param id the id
	 * @return the matches api
	 */
	public String getMatchesApi(Long id) {
		// https://rest.entitysport.com/v2/competitions/90534/matches?token=
		competitionsUrl = "/competitions/" + id + "/matches";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();

	}

	/**
	 * Gets the players api.
	 *
	 * @param id the id
	 * @return the players api
	 */
	public String getPlayersApi(Long id) {
		// https://rest.entitysport.com/v2/competitions/90534/squads?token=
		competitionsUrl = "/competitions/" + id + "/squads";

		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();
	}

	/**
	 * Gets the player info.
	 *
	 * @param player_id the player id
	 * @return the player info
	 */
	public String getPlayerInfo(Long player_id) {
		// https://rest.entitysport.com/v2/players/119?token=
		competitionsUrl = "/players/" + player_id;

		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();
	}

	/**
	 * Gets the scorecard.
	 *
	 * @param id the id
	 * @return the scorecard
	 */
	public String getScorecard(Long id) {

		// https://rest.entitysport.com/v2/matches/19899/scorecard?token=

		competitionsUrl = "/matches/" + id + "/scorecard";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();
	}

	/**
	 * Gets the live status.
	 *
	 * @param id the id
	 * @return the live status
	 */
	public String getLiveStatus(Long id) {

		// https://rest.entitysport.com/v2/matches/19899/live?token=

		competitionsUrl = "/matches/" + id + "/live";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);

		return baseUrl.toString();
	}

	/**
	 * Gets the match squad.
	 *
	 * @param id the id
	 * @return the match squad
	 */
	public String getMatchSquad(Long id) {
		// https://rest.entitysport.com/v2/matches/19899/squads?token=
		competitionsUrl = "/matches/" + id + "/squads";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);
		return baseUrl.toString();
	}

	/**
	 * Gets the inning scoreboard.
	 *
	 * @param id  the id
	 * @param id1 the id 1
	 * @return the inning scoreboard
	 */
	public String getInningScoreboard(Long id, int id1) {
		// https://rest.entitysport.com/v2/matches/19899/innings/1/scorecard?token=
		competitionsUrl = "/matches/" + id + "/innings" + id1 + "/scorecard";
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/" + competitionsUrl);
		baseUrl.append("?token=" + RestTemplateConfig.apiTocken);
		return baseUrl.toString();
	}

}
