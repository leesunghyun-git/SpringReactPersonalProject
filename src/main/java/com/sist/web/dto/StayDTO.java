package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
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
	private String checkingtime;
	private String checkouttime;
	private String chkcooking;
	private String subfacility;
	private String foodplace;
	private String reservationurl;
	private String infocenter;
	private String parking;
	private String msg;
}
