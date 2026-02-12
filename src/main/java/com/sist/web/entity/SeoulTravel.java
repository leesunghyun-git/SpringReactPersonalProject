package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * NO bigint 
TITLE varchar(1024) 
IMAGE1 varchar(1024) 
IMAGE2 varchar(1024) 
X double 
Y double 
CONTENTID bigint 
ADDRESS varchar(300) 
CONTENTTYPE bigint 
HIT bigint
 */
@Entity
@Table(name="seoultravel")
@Data
public class SeoulTravel {
	
	
	private int no;
	private String title;
	private String image1;
	private String image2;
	private double x;
	private double y;
	@Id
	private int contentid;
	
	private String address;
	private int contenttype;
	private int hit;
	
	
}
