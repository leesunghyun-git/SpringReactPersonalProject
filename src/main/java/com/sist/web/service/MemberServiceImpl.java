package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.entity.Member;
import com.sist.web.repository.MemberRepository;
import com.sist.web.repository.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private MemberRepository mRepo;
	private UserRoleRepository urRepo;
	@Override
	public Member findByUsernameAndProvider(String username, String provider) {
		// TODO Auto-generated method stub
		return mRepo.findByUsernameAndProvider(username, provider).orElse(null);
	}
	@Override
	public String findRoleNameByUserNameAndProvider(String provider, String username) {
		// TODO Auto-generated method stub
		return urRepo.findRoleNameByUserNameAndProvider(provider,username);
	}
	@Override
	public List<String> userAuthoritiesByUsernameAndProvider(String provider, String username) {
		// TODO Auto-generated method stub
		return urRepo.userAuthoritiesByUsernameAndProvider(provider,username);
	}
}
