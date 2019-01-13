package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.MInvitePlatform;

// TODO: Auto-generated Javadoc
/**
 * The Interface MInvitePlatformDAO.
 */
public interface MInvitePlatformDAO {

	/**
	 * Gets the all M invite platform.
	 *
	 * @return the all M invite platform
	 */
	List<MInvitePlatform> getAllMInvitePlatform();

	/**
	 * Gets the m invite platform by id.
	 *
	 * @param id the id
	 * @return the m invite platform by id
	 */
	MInvitePlatform getMInvitePlatformById(Long id);

	/**
	 * Adds the M invite platform.
	 *
	 * @param mInvitePlatform the m invite platform
	 */
	MInvitePlatform addMInvitePlatform(MInvitePlatform mInvitePlatform);

	/**
	 * Update M invite platform.
	 *
	 * @param mInvitePlatform the m invite platform
	 */
	MInvitePlatform updateMInvitePlatform(MInvitePlatform mInvitePlatform);

	/**
	 * Delete M invite platform.
	 *
	 * @param id the id
	 */
	void deleteMInvitePlatform(Long id);

}
