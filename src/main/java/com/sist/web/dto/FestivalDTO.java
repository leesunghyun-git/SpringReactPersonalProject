package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FestivalDTO extends TravelDetailDTO{
/*
 * NO bigint 
CONTENTID bigint 
EVENTSTARTDATE varchar(1024) 
EVENTENDDATE varchar(1024) 
AGELIMIT varchar(1024) 
PLAYTIME varchar(1024) 
EVENTPLACE varchar(1024) 
EVENTHOMEPAGE varchar(1024) 
USETIME varchar(1024) 
SPENDTIME varchar(1024) 
MSG longblob
 */
	private String eventstartdate;
	private String eventenddate;
	private String agelimit;
	private String playtime;
	private String eventplace;
	private String eventhomepage;
	private String usetime;
	private String spendtime;
	private String msg;
}
