package com.mb11.application.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mb11.application.dao.user.PrivilegeRepository;
import com.mb11.application.dao.user.RoleRepository;
import com.mb11.application.dao.user.UserRepository;
import com.mb11.application.model.user.AuthProvider;
import com.mb11.application.model.user.Privilege;
import com.mb11.application.model.user.Role;
import com.mb11.application.model.user.User;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup)
			return;

		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ADMIN", adminPrivileges);
		createRoleIfNotFound("USER", Arrays.asList(readPrivilege));
		Role adminRole = roleRepository.findByName("ADMIN");
		Role userRole = roleRepository.findByName("USER");
		if (!userRepository.existsByEmail("test@test.com")) {
			User adminUser = new User();
			adminUser.setFirstname("Test");
			adminUser.setLastname("Test");
			adminUser.setPassword(passwordEncoder.encode("test"));
			adminUser.setEmail("");
			adminUser.setRoles(Arrays.asList(adminRole));
			adminUser.setProvider(AuthProvider.local);
			adminUser.setProviderId("local");
			userRepository.save(adminUser);
		}

		if (!userRepository.existsByEmail("khushi@test.com")) {
			User adminAndUser = new User();
			adminAndUser.setFirstname("Khushu");
			adminAndUser.setLastname("Dabhs");
			adminAndUser.setPassword(passwordEncoder.encode("khushi"));
			adminAndUser.setEmail("khushi@test.com");
			adminAndUser.setRoles(Arrays.asList(adminRole, userRole));
			adminAndUser.setProvider(AuthProvider.local);
			adminAndUser.setProviderId("local");
			userRepository.save(adminAndUser);
		}

		alreadySetup = true;
	}

	@Transactional
	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
			roleRepository.save(role);
		}
		return role;
	}

	private Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

}
