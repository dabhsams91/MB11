package com.mb11.application.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.exception.ResourceNotFoundException;
import com.mb11.application.model.user.User;
import com.mb11.application.service.user.UsersService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersService usersService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = usersService.findByEmail(email);
		if (user == null)
			new UsernameNotFoundException("User not found with email : " + email);

		return UserPrincipal.create(user.get());
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = usersService.getUsersById(id);
		if (user == null)
			new ResourceNotFoundException("User", "id", id);
		return UserPrincipal.create(user);
	}

}