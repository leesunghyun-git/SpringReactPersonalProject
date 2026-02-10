package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * id int AI PK 
role_name varchar(51) 
perm_name varchar(51)
 */
@Entity
@Table(name="role_permissons")
@Data
public class Role_perm {
	@Id
	private int id;
	private String role_name;
	private String perm_name;
}
