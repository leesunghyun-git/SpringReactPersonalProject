package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class AttractionDTO extends TravelDetailDTO{
	private String infocenter;
	private String restdate;
	private String usetime;
	private String pakring;
	private String msg;
}
