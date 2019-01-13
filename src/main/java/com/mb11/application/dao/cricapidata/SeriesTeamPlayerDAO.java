package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.SeriesTeamPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeriesTeamPlayerDAO.
 */
public interface SeriesTeamPlayerDAO {

	/**
	 * Gets the all series team player.
	 *
	 * @return the all series team player
	 */
	List<SeriesTeamPlayer> getAllSeriesTeamPlayer();

	/**
	 * Gets the series team player by id.
	 *
	 * @param id the id
	 * @return the series team player by id
	 */
	SeriesTeamPlayer getSeriesTeamPlayerById(Long id);

	/**
	 * Adds the series team player.
	 *
	 * @param seriesTeamPlayer the series team player
	 */
	SeriesTeamPlayer addSeriesTeamPlayer(SeriesTeamPlayer seriesTeamPlayer);

	/**
	 * Update series team player.
	 *
	 * @param seriesTeamPlayer the series team player
	 */
	SeriesTeamPlayer updateSeriesTeamPlayer(SeriesTeamPlayer seriesTeamPlayer);

	/**
	 * Delete series team player.
	 *
	 * @param id the id
	 */
	void deleteSeriesTeamPlayer(Long id);

}
