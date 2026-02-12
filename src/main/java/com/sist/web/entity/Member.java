package com.sist.web.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * no int AI PK 
username varchar(50) 
provider varchar(30) 
name varchar(50) 
pwd varchar(400) 
regdate datetime 
nickname varchar(60) 
email varchar(60)
state int 
 */
@Entity
@Table(name="member")
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	private String username;
	private String provider;
	private String name;
	private String pwd;
	private Date regdate;
	private String nickname;
	private String email;
	
	private int state;
}
