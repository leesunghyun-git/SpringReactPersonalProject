package com.sist.web.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sist.web.config.CustomOAuth2User;
import com.sist.web.entity.Member;
import com.sist.web.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	private final JwtProvider jpv;
	private final MemberService mService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		if(authentication.getPrincipal() instanceof CustomOAuth2User)
		{
			CustomOAuth2User ouathUser = (CustomOAuth2User) authentication.getPrincipal();
			if(!ouathUser.isRegistered()) {
				
				response.getWriter().write("""
						{
							"status":"NOTUSER",
							"username":"%s",
							"provider":"%s"
						}
						""".formatted(
								ouathUser.getUsername(),
								ouathUser.getProvider()));
				return;
			}
			else {
				String username = ouathUser.getUsername();
				String provider = ouathUser.getProvider();
				String role = ouathUser.getRole();
				String accessToken = jpv.createAccessToken(username, provider, role);
				String refreshToken = jpv.createRefreshToken(username, provider);
				
				response.getWriter().write("""
						{
							"status":"OK",
							"accessToken":"%s",
							"refreshToken":"%s"
						}
						""".formatted(
								accessToken,
								refreshToken));
				return;
			}
		}
		else {
			Member vo = mService.findByUsernameAndProvider(authentication.getName(), "local");
			String role=mService.findRoleNameByUserNameAndProvider(vo.getProvider(),vo.getUsername());
			String accessToken = jpv.createAccessToken(vo.getUsername(), vo.getProvider(), role);
			String refreshToken = jpv.createRefreshToken(vo.getUsername(), vo.getProvider());
			
			response.getWriter().write("""
					{
						"status":"OK",
						"accessToken":"%s",
						"refreshToken":"%s"
					}
					""".formatted(
							accessToken,
							refreshToken));
			return;
		}
		
	}
}
