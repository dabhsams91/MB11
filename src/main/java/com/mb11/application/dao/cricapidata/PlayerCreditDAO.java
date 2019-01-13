package com.mb11.application.dao.cricapidata;

import java.util.List;

import com.mb11.application.model.cricapidata.PlayerCredit;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlayerCreditDAO.
 */
public interface PlayerCreditDAO {

	/**
	 * Gets the all player credit.
	 *
	 * @return the all player credit
	 */
	List<PlayerCredit> getAllPlayerCredit();

	/**
	 * Gets the player credit by id.
	 *
	 * @param id the id
	 * @return the player credit by id
	 */
	PlayerCredit getPlayerCreditById(Long id);

	/**
	 * Adds the player credit.
	 *
	 * @param playerCredit the player credit
	 */
	PlayerCredit addPlayerCredit(PlayerCredit playerCredit);

	/**
	 * Update player credit.
	 *
	 * @param playerCredit the player credit
	 */
	PlayerCredit updatePlayerCredit(PlayerCredit playerCredit);

	/**
	 * Delete player credit.
	 *
	 * @param id the id
	 */
	void deletePlayerCredit(Long id);

}
