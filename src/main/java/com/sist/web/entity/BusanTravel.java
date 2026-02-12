package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="busantravel")
@Data
public class BusanTravel {
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
