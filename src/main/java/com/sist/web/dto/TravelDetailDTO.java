package com.sist.web.dto;

import lombok.Data;

@Data
public class TravelDetailDTO {
	private String title;
	private String image1;
	private double x;
	private double y;
	private int contentid;
	private String address;
	private int contenttype;
	private int hit;
}
