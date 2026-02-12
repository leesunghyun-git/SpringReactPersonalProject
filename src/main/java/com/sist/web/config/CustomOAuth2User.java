package com.sist.web.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User{
	private final OAuth2User oauth2user;
	private final String provider;
	private final String username;
	private final boolean isRegistered;
	private final String role;
	
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return oauth2user.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getProvider() {
		return provider;
	}

	public String getUsername() {
		return username;
	}

	public boolean isRegistered() {
		return isRegistered;
	}
	
	public String getRole() {
		return role;
	}
	
}
