package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.MatchTeamLink;

// TODO: Auto-generated Javadoc
/**
 * The Interface MatchTeamLinkDAO.
 */
public interface MatchTeamLinkDAO {
	
    /**
     * Gets the all match team link.
     *
     * @return the all match team link
     */
    List<MatchTeamLink> getAllMatchTeamLink();
	
	/**
	 * Gets the match team link by id.
	 *
	 * @param id the id
	 * @return the match team link by id
	 */
	MatchTeamLink getMatchTeamLinkById(Long id);
	
	/**
	 * Adds the match team link.
	 *
	 * @param matchTeamLink the match team link
	 */
	MatchTeamLink addMatchTeamLink(MatchTeamLink matchTeamLink);
	
	/**
	 * Update match team link.
	 *
	 * @param matchTeamLink the match team link
	 */
	MatchTeamLink updateMatchTeamLink(MatchTeamLink matchTeamLink);
	
	/**
	 * Delete match team link.
	 *
	 * @param id the id
	 */
	void deleteMatchTeamLink(Long id);


}
