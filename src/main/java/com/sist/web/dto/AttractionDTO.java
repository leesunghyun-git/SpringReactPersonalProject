package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
 *NO bigint 
CONTENTID bigint 
INFOCENTER varchar(1024) 
RESTDATE varchar(1024) 
USETIME varchar(1024) 
PARKING varchar(1024) 
MSG longblob 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class AttractionDTO extends TravelDetailDTO{
	private String infocenter;
	private String restdate;
	private String usetime;
	private String parking;
	private String msg;

	public AttractionDTO(String title, String image1, double x, double y, int contentid,
	                  String address, int contenttype, int hit, String infocenter,
	                  String restdate, String usetime, String parking,
	                  String msg) {
		// 부모 클래스 필드 초기화
		super.setTitle(title);
		super.setImage1(image1);
		super.setX(x);
		super.setY(y);
		super.setContentid(contentid);
		super.setAddress(address);
		super.setContenttype(contenttype);
		super.setHit(hit);

		// 자식 클래스 필드 초기화
		this.infocenter = infocenter;
		this.usetime = usetime;
		this.restdate = restdate;
		this.parking = parking;
		this.msg = msg;
	}
}
