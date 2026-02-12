package com.sist.web.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter{
	private final JwtProvider jwtProvider;
	private final UserDetailsService userDetailsService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader = request.getHeader("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(authHeader.indexOf(" ")+1);
			if(jwtProvider.validateToken(token)) {
				String username=jwtProvider.getUsername(token);
				String provider= jwtProvider.getProvider(token);
				String usernameAndProvider = username+"|"+provider;
				UserDetails userDetails = userDetailsService.loadUserByUsername(usernameAndProvider);
				
				UsernamePasswordAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
