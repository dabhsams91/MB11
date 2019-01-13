package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.TeamPlayers;

// TODO: Auto-generated Javadoc
/**
 * The Interface TeamPlayersDAO.
 */
public interface TeamPlayersDAO {

	/**
	 * Gets the all team players.
	 *
	 * @return the all team players
	 */
	List<TeamPlayers> getAllTeamPlayers();

	/**
	 * Gets the team players by id.
	 *
	 * @param id the id
	 * @return the team players by id
	 */
	TeamPlayers getTeamPlayersById(Long id);

	/**
	 * Adds the team players.
	 *
	 * @param teamPlayers the team players
	 */
	TeamPlayers addTeamPlayers(TeamPlayers teamPlayers);

	/**
	 * Update team players.
	 *
	 * @param teamPlayers the team players
	 */
	TeamPlayers updateTeamPlayers(TeamPlayers teamPlayers);

	/**
	 * Delete team players.
	 *
	 * @param id the id
	 */
	void deleteTeamPlayers(Long id);

}
