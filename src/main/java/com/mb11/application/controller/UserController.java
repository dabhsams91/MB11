package com.mb11.application.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb11.application.exception.ResourceNotFoundException;
import com.mb11.application.model.user.User;
import com.mb11.application.payload.user.Role;
import com.mb11.application.security.CurrentUser;
import com.mb11.application.security.UserPrincipal;
import com.mb11.application.service.user.UsersService;

@RestController
public class UserController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public com.mb11.application.payload.user.User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {

		User user = usersService.getUsersById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

		com.mb11.application.payload.user.User payloadUser = new com.mb11.application.payload.user.User();
		payloadUser.setID(user.getID());
		payloadUser.setCreatetime(user.getCreatetime());
		payloadUser.setDob(user.getDob());
		payloadUser.setEmail(user.getEmail());
		payloadUser.setEmailVerified(user.isEmailVerified());
		payloadUser.setFirstname(user.getFirstname());
		payloadUser.setLastname(user.getLastname());
		payloadUser.setMiddlename(user.getMiddlename());
		payloadUser.setMobilenumber(user.getMobilenumber());
		payloadUser.setName(user.getName());
		payloadUser.setProviderId(user.getProviderId());
		payloadUser.setReffrencecode(user.getReffrencecode());
		payloadUser.setUpdatetime(user.getUpdatetime());

		if (user.getRoles() != null) {
			Set<Role> roles = new HashSet<>();
			for (com.mb11.application.model.user.Role role : user.getRoles()) {
				Role payloadRole = new Role();
				payloadRole.setID(role.getID());
				payloadRole.setName(role.getName());
				roles.add(payloadRole);
			}
			payloadUser.setRoles(roles);
		}

		return payloadUser;
	}

	@GetMapping("/admin/me")
	@PreAuthorize("hasRole('ADMIN')")
	public com.mb11.application.payload.user.User getCurrentAdmin(@CurrentUser UserPrincipal userPrincipal) {

		User user = usersService.getUsersById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

		com.mb11.application.payload.user.User payloadUser = new com.mb11.application.payload.user.User();
		payloadUser.setID(user.getID());
		payloadUser.setCreatetime(user.getCreatetime());
		payloadUser.setDob(user.getDob());
		payloadUser.setEmail(user.getEmail());
		payloadUser.setEmailVerified(user.isEmailVerified());
		payloadUser.setFirstname(user.getFirstname());
		payloadUser.setLastname(user.getLastname());
		payloadUser.setMiddlename(user.getMiddlename());
		payloadUser.setMobilenumber(user.getMobilenumber());
		payloadUser.setName(user.getName());
		payloadUser.setProviderId(user.getProviderId());
		payloadUser.setReffrencecode(user.getReffrencecode());
		payloadUser.setUpdatetime(user.getUpdatetime());

		if (user.getRoles() != null) {
			Set<Role> roles = new HashSet<>();
			for (com.mb11.application.model.user.Role role : user.getRoles()) {
				Role payloadRole = new Role();
				payloadRole.setID(role.getID());
				payloadRole.setName(role.getName());
				roles.add(payloadRole);
			}
			payloadUser.setRoles(roles);
		}

		return payloadUser;
	}
}
