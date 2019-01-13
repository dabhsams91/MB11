package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.User;



// TODO: Auto-generated Javadoc
/**
 * The Interface UsersDAO.
 */
public interface UsersDAO {
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	List<User> getAllUsers();
	
	/**
	 * Gets the users by id.
	 *
	 * @param id the id
	 * @return the users by id
	 */
	User getUsersById(Long id);
	
	/**
	 * Adds the users.
	 *
	 * @param users the users
	 */
	User addUsers(User users);
	
	/**
	 * Update users.
	 *
	 * @param users the users
	 */
	User updateUsers(User users);
	
	/**
	 * Delete users.
	 *
	 * @param id the id
	 */
	void deleteUsers(Long id);
	
	
	/**
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
    
    /**
     * @param mobilenumber
     * @return
     */
    User findByMobilenumber(String mobilenumber);
    
}
