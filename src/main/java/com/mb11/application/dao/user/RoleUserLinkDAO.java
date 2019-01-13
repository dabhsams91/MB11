package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.RoleUserLink;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleUserLinkDAO.
 */
public interface RoleUserLinkDAO {

	/**
	 * Gets the all role user link.
	 *
	 * @return the all role user link
	 */
	List<RoleUserLink> getAllRoleUserLink();

	/**
	 * Gets the role user link by id.
	 *
	 * @param id the id
	 * @return the role user link by id
	 */
	RoleUserLink getRoleUserLinkById(Long id);

	/**
	 * Adds the role user link.
	 *
	 * @param roleUserLink the role user link
	 */
	RoleUserLink addRoleUserLink(RoleUserLink roleUserLink);

	/**
	 * Update role user link.
	 *
	 * @param roleUserLink the role user link
	 */
	RoleUserLink updateRoleUserLink(RoleUserLink roleUserLink);

	/**
	 * Delete role user link.
	 *
	 * @param id the id
	 */
	void deleteRoleUserLink(Long id);

}
