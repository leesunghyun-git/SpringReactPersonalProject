package com.sist.web.service;


import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Member;

public interface MemberService {
	Member findByUsernameAndProvider(String username,String provider);
	String findRoleNameByUserNameAndProvider(String provider,String username);
	List<String> userAuthoritiesByUsernameAndProvider(String provider,String username);
}
