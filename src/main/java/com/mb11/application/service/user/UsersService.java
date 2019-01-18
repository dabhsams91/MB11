package com.mb11.application.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.user.UserRepository;
import com.mb11.application.model.user.User;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	public User getUsersById(Long id) {
		User obj = userRepository.getOne(id);
		return obj;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addUsers(User usr) {
		return userRepository.save(usr);
	}

	public User updateUsers(User usr) {
		return userRepository.saveAndFlush(usr);
	}

	public void deleteUsers(User usr) {
		userRepository.delete(usr);
	}

	/**
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	/**
	 * @param mobilenumber
	 * @return
	 */
	public User findByMobilenumber(String mobilenumber) {
		return userRepository.findByMobilenumber(mobilenumber);

	}

}
