package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FoodStoreDTO extends TravelDetailDTO{
	/*
	 * NO bigint 
CONTENTID bigint 
FIRSTMENU varchar(1024) 
TREATMENU varchar(1024) 
INFOCENTER varchar(1024) 
PARKING varchar(1024) 
OPENDATE varchar(1024) 
OPENTIME varchar(1024) 
RESTDATE varchar(1024) 
MSG longblob
	 */
	private String firstmenu;
	private String treatmenu;
	private String infocenter;
	private String parking;
	private String opendate;
	private String opentime;
	private String restdate;
	private String msg;
}
