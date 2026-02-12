package com.sist.web.security;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class LoginFailuerHandler implements AuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String errorMsg ="";
		response.setContentType("application/json;charset=UTF-8");
		try {
			if(exception instanceof BadCredentialsException)
			{
				errorMsg="NOID";
			}
			else if(exception instanceof InternalAuthenticationServiceException)
			{
				errorMsg="NOPWD";
			}
			else if(exception instanceof DisabledException)
			{
				errorMsg="SLEEP";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		response.getWriter().write("""
				{
					"status":"%s"
				}
				""".formatted(errorMsg));
	}
}
