package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.UserInvitePlatformLink;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInvitePlatformLinkDAO.
 */
public interface UserInvitePlatformLinkDAO {

	/**
	 * Gets the all user invite platform link.
	 *
	 * @return the all user invite platform link
	 */
	List<UserInvitePlatformLink> getAllUserInvitePlatformLink();

	/**
	 * Gets the user invite platform link by id.
	 *
	 * @param id the id
	 * @return the user invite platform link by id
	 */
	UserInvitePlatformLink getUserInvitePlatformLinkById(Long id);

	/**
	 * Adds the user invite platform link.
	 *
	 * @param userInvitePlatformLink the user invite platform link
	 */
	UserInvitePlatformLink addUserInvitePlatformLink(UserInvitePlatformLink userInvitePlatformLink);

	/**
	 * Update user invite platform link.
	 *
	 * @param userInvitePlatformLink the user invite platform link
	 */
	UserInvitePlatformLink updateUserInvitePlatformLink(UserInvitePlatformLink userInvitePlatformLink);

	/**
	 * Delete user invite platform link.
	 *
	 * @param id the id
	 */
	void deleteUserInvitePlatformLink(Long id);

}
