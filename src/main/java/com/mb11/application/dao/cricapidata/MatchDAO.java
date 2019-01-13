package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.Match;

// TODO: Auto-generated Javadoc
/**
 * The Interface MatchDAO.
 */
public interface MatchDAO {
	
    /**
     * Gets the all match.
     *
     * @return the all match
     */
    List<Match> getAllMatch();
	
	/**
	 * Gets the match by id.
	 *
	 * @param id the id
	 * @return the match by id
	 */
	Match getMatchById(Long id);
	
	/**
	 * Adds the match.
	 *
	 * @param match the match
	 */
	Match addMatch(Match match);
	
	/**
	 * Update match.
	 *
	 * @param match the match
	 */
	Match updateMatch(Match match);
	
	/**
	 * Delete match.
	 *
	 * @param id the id
	 */
	void deleteMatch(Long id);
	
	

}
