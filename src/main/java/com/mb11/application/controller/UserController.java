package com.mb11.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb11.application.exception.ResourceNotFoundException;
import com.mb11.application.model.user.User;
import com.mb11.application.repository.user.UserRepository;
import com.mb11.application.security.CurrentUser;
import com.mb11.application.security.UserPrincipal;

@RestController
public class UserController {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
    	
        return userRepository.findById(userPrincipal.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
