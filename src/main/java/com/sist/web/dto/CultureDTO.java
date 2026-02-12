package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
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
}
