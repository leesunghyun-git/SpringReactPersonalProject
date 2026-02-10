package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Role_perm;

public interface RoleRepository extends JpaRepository<Role_perm, Integer>{
	
}
