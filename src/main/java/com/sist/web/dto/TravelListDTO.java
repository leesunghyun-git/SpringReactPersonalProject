package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TravelListDTO {
	private String title;
	private String image1;
	private int contentid;
	private String address;
	private int contenttype;
	private int hit;
}
