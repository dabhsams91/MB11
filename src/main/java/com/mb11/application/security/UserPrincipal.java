package com.mb11.application.security;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.mb11.application.model.user.Role;
import com.mb11.application.model.user.User;

public class UserPrincipal implements OAuth2User, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String password;
	private BigDecimal mobilenumber;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;

	public UserPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public UserPrincipal(Long id, BigDecimal mobilenumber, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
		Collection<Role> roles = user.getRoles();

		if (roles == null) {
			return null;
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			if (role.getName().equals("ADMIN")) {
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			} else {
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			}

		}

		return new UserPrincipal(user.getID(), user.getEmail(), user.getPassword(), authorities);
	}

	public static UserPrincipal create(User user, Map<String, Object> attributes) {
		UserPrincipal userPrincipal = UserPrincipal.create(user);
		userPrincipal.setAttributes(attributes);
		return userPrincipal;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getMobilenumber() {
		return mobilenumber;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getName() {
		return String.valueOf(id);
	}

}
