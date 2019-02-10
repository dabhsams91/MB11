package com.mb11.application.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.user.RoleRepository;
import com.mb11.application.dao.user.UserRepository;
import com.mb11.application.model.user.Role;
import com.mb11.application.model.user.User;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Role getRole(String roleName) {

		return roleRepository.findByName(roleName);

	}

	public Optional<User> getUsersById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addUsers(User usr) {
		return userRepository.saveAndFlush(usr);
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
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	/**
	 * @param mobilenumber
	 * @return
	 */
	public Optional<User> findByMobilenumber(String mobilenumber) {
		return userRepository.findByMobilenumber(mobilenumber);

	}

}
