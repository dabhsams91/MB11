package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.Roles;

// TODO: Auto-generated Javadoc
/**
 * The Interface RolesDAO.
 */
public interface RolesDAO {

	/**
	 * Gets the all roles.
	 *
	 * @return the all roles
	 */
	List<Roles> getAllRoles();

	/**
	 * Gets the roles by id.
	 *
	 * @param id the id
	 * @return the roles by id
	 */
	Roles getRolesById(Long id);

	/**
	 * Adds the roles.
	 *
	 * @param roles the roles
	 */
	Roles addRoles(Roles roles);

	/**
	 * Update roles.
	 *
	 * @param roles the roles
	 */
	Roles updateRoles(Roles roles);

	/**
	 * Delete roles.
	 *
	 * @param id the id
	 */
	void deleteRoles(Long id);

}
