package com.sist.web.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Member;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomUsersDetailService implements UserDetailsService{
	private final MemberService mService;
	
	@Override
	public UserDetails loadUserByUsername(String usernameAndProvider) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		System.out.println("커스텀 유저 디테일 서비스 호출");
		String username = usernameAndProvider.substring(0,usernameAndProvider.lastIndexOf("|"));
		String provider = usernameAndProvider.substring(usernameAndProvider.indexOf("|")+1);
		Member user = mService.findByUsernameAndProvider(username, provider);
		if(user == null)
		{
			throw new UsernameNotFoundException("가입된 회원이 아닙니다.");
		}
		String role=mService.findRoleNameByUserNameAndProvider(user.getProvider(),user.getUsername());
		role=role.substring(role.indexOf("_")+1);
		return User.builder()
				.username(username)
				.password(user.getPwd())
				.roles(role)
				.disabled(user.getState()==1?false:true)
				.build();
	}
	
}
