package com.mb11.application.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mb11.application.entitysport.converter.UserDataConverter;
import com.mb11.application.exception.BadRequestException;
import com.mb11.application.model.user.AuthProvider;
import com.mb11.application.model.user.User;
import com.mb11.application.payload.ApiResponse;
import com.mb11.application.payload.AuthResponse;
import com.mb11.application.payload.Login;
import com.mb11.application.payload.SignUp;
import com.mb11.application.security.TokenProvider;
import com.mb11.application.service.user.UsersService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsersService usersService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login login) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUp signUpRequest) {
		if (usersService.findByEmail(signUpRequest.getEmail()).isPresent()) {
			throw new BadRequestException("Email address already in use.");
		} else if (signUpRequest.getMobilenumber() != null && !signUpRequest.getMobilenumber().isEmpty()
				&& usersService.findByMobilenumber(signUpRequest.getMobilenumber()).isPresent()) {
			throw new BadRequestException("Mobile number already in use.");
		}

		// Creating user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		user.setProvider(AuthProvider.local);
		if (signUpRequest.getMobilenumber() != null) {
			user.setMobilenumber(signUpRequest.getMobilenumber());
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User result = usersService.addUsers(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getID()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));
	}

	@PostMapping("/saveprofile")
	public ResponseEntity<?> saveUserProfile(@Valid @RequestBody com.mb11.application.payload.user.User user) {

		Optional<User> userModel = usersService.getUsersById(user.getID());
		if (!userModel.isPresent()) {
			ResponseEntity.badRequest().body("User profile is missing.");
		}
		UserDataConverter userDataConverter = new UserDataConverter();
		User latestUserModel = userModel.get();
		userDataConverter.getUserModelFromUserPayload(user, latestUserModel);

		User result = usersService.addUsers(latestUserModel);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getID()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));

	}

}
