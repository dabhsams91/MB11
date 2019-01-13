package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.SeriesTeamLink;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeriesTeamLinkDAO.
 */
public interface SeriesTeamLinkDAO {

	/**
	 * Gets the all series team link.
	 *
	 * @return the all series team link
	 */
	List<SeriesTeamLink> getAllSeriesTeamLink();

	/**
	 * Gets the series team link by id.
	 *
	 * @param id the id
	 * @return the series team link by id
	 */
	SeriesTeamLink getSeriesTeamLinkById(Long id);

	/**
	 * Adds the series team link.
	 *
	 * @param seriesTeamLink the series team link
	 */
	SeriesTeamLink addSeriesTeamLink(SeriesTeamLink seriesTeamLink);

	/**
	 * Update series team link.
	 *
	 * @param seriesTeamLink the series team link
	 */
	SeriesTeamLink updateSeriesTeamLink(SeriesTeamLink seriesTeamLink);

	/**
	 * Delete series team link.
	 *
	 * @param id the id
	 */
	void deleteSeriesTeamLink(Long id);

}
