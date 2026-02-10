package com.sist.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
@Repository
public interface MemberRepository extends JpaRepository<Member,Integer>{
	
	Optional<Member> findByUsernameAndProvider(String username,String provider);
}
