package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	@Query(value="SELECT ROLE_NAME FROM user_roles WHERE user_no = (SELECT no FROM member WHERE provider=:provider AND username = :username)",nativeQuery = true)
	List<String> findRoleNameByUserNameAndProvider(@Param("provider")String provider,@Param("username")String username);
}
