package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.MTeam;



// TODO: Auto-generated Javadoc
/**
 * The Interface MTeamDAO.
 */
public interface MTeamDAO {
	
	/**
	 * Gets the all M team.
	 *
	 * @return the all M team
	 */
	List<MTeam> getAllMTeam();
	
	/**
	 * Gets the m team by id.
	 *
	 * @param id the id
	 * @return the m team by id
	 */
	MTeam getMTeamById(Long id);
	
	/**
	 * Adds the M team.
	 *
	 * @param mTeam the m team
	 */
	MTeam addMTeam(MTeam mTeam);
	
	/**
	 * Update M team.
	 *
	 * @param mTeam the m team
	 */
	MTeam updateMTeam(MTeam mTeam);
	
	/**
	 * Delete M team.
	 *
	 * @param id the id
	 */
	void deleteMTeam(Long id);

}
