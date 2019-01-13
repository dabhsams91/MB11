package com.mb11.application.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.user.UsersDaoImpl;
import com.mb11.application.model.user.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersService.
 */
@Service
public class UsersService {

	/** The users dao. */
	@Autowired
	private UsersDaoImpl usersDao;

	/**
	 * Gets the users by id.
	 *
	 * @param id the id
	 * @return the users by id
	 */
	public User getUsersById(Long id) {
		User obj = usersDao.getUsersById(id);
		return obj;
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

	/**
	 * Adds the users.
	 *
	 * @param usr the usr
	 * @return true, if successful
	 */
	public User addUsers(User usr) {
		return usersDao.addUsers(usr);
	}

	/**
	 * Update users.
	 *
	 * @param usr the usr
	 */
	public User updateUsers(User usr) {
		return usersDao.updateUsers(usr);
	}

	/**
	 * Delete users.
	 *
	 * @param id the id
	 */
	public void deleteUsers(Long id) {
		usersDao.deleteUsers(id);
	}

	/**
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		return usersDao.findByEmail(email);

	}

	/**
	 * @param mobilenumber
	 * @return
	 */
	public User findByMobilenumber(String mobilenumber) {
		return usersDao.findByMobilenumber(mobilenumber);

	}

}
