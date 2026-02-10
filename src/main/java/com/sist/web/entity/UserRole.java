package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * Columns:
no int AI PK 
user_no int 
role_name varchar(51)
 */
@Entity
@Table(name="user_role")
@Data
public class UserRole {
	@Id
	private int no;
	
	private int user_no;
	private String role_name;
}
