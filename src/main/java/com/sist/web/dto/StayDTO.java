package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class StayDTO extends TravelDetailDTO{
	/*
	 * NO bigint 
CONTENTID bigint 
ROOMTYPE varchar(1024) 
CHECKINTIME varchar(1024) 
CHECKOUTTIME varchar(1024) 
CHKCOOKING varchar(1024) 
SUBFACILITY varchar(1024) 
FOODPLACE varchar(1024) 
RESERVATIONURL varchar(1024) 
INFOCENTER varchar(1024) 
PARKING varchar(1024) 
MSG longblob
	 */
	private String roomtype;
	private String checkintime;
	private String checkouttime;
	private String chkcooking;
	private String subfacility;
	private String foodplace;
	private String reservationurl;
	private String infocenter;
	private String parking;
	private String msg;

	public StayDTO(String title, String image1, double x, double y, int contentid,
	                   String address, int contenttype, int hit,
	               	    String roomtype, String checkintime, String checkouttime, String chkcooking, String subfacility,
						   String foodplace,String reservationurl, String infocenter, String parking,
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
		this.roomtype = roomtype;
		this.checkintime = checkintime;
		this.checkouttime = checkouttime;
		this.chkcooking = chkcooking;
		this.subfacility = subfacility;
		this.foodplace = foodplace;
		this.reservationurl = reservationurl;
		this.infocenter = infocenter;
		this.parking = parking;
		this.msg = msg;
	}
}
