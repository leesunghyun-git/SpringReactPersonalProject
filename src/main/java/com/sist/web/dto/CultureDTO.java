package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class CultureDTO extends TravelDetailDTO{
/*
 * NO bigint 
CONTENTID bigint 
USEFEE varchar(1024) 
SPENDTIME varchar(1024) 
PARKINGFEE varchar(1024) 
DISCOUNTINFO varchar(1024) 
INFOCENTER varchar(1024) 
USETIME varchar(1024) 
RESTDATE varchar(1024) 
PARKING varchar(1024) 
MSG longblob
 */
	private String usefee;
	private String spendtime;
	private String parkingfee;
	private String discountinfo;
	private String infocenter;
	private String usetime;
	private String restdate;
	private String parking;
	private String msg;

	public CultureDTO(String title, String image1, double x, double y, int contentid,
	                  String address, int contenttype, int hit, String usefee,
	                  String spendtime, String parkingfee, String discountinfo,
	                  String infocenter, String usetime, String restdate,
	                  String parking, String msg) {
		super.setTitle(title);
		super.setImage1(image1);
		super.setX(x);
		super.setY(y);
		super.setContentid(contentid);
		super.setAddress(address);
		super.setContenttype(contenttype);
		super.setHit(hit);

		// 자식 클래스 필드 초기화
		this.usefee = usefee;
		this.spendtime = spendtime;
		this.parkingfee = parkingfee;
		this.discountinfo = discountinfo;
		this.infocenter = infocenter;
		this.usetime = usetime;
		this.restdate = restdate;
		this.parking = parking;
		this.msg = msg;
	}
}
