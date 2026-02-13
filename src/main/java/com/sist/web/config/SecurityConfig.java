package com.sist.web.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sist.web.security.JwtFilter;
import com.sist.web.security.LoginFailuerHandler;
import com.sist.web.security.LoginSuccessHandler;
import com.sist.web.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final CustomOAuth2UserService oauth2UserService;
    private final JwtFilter jwtFilter;
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailuerHandler loginFailuerHandler;
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable())
			.cors(cors->cors.configurationSource(corsConfigurationSource()))
			.sessionManagement(session -> 
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/").permitAll()
					.anyRequest().permitAll()
			)
			.oauth2Login(ouath2 -> ouath2
			.loginProcessingUrl("/mebmer/social/login")
			.userInfoEndpoint(userInfo -> userInfo
					.userService(oauth2UserService))
			.successHandler(loginSuccessHandler)
			)
			.formLogin(form -> form
					.loginProcessingUrl("/member/local/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.successHandler(loginSuccessHandler)
					.failureHandler(loginFailuerHandler)
					.permitAll()
			)
			.logout(logout -> logout
					.logoutUrl("/member/logout")
					.invalidateHttpSession(true)
					.deleteCookies(""))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(List.of("http://localhost:3000"));
	    config.setAllowedMethods(List.of("*"));
	    config.setAllowedHeaders(List.of("*"));
	    config.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source =
	        new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return source;
	}
}
