package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
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

	public FestivalDTO(String title, String image1, double x, double y, int contentid,
	                     String address, int contenttype, int hit,
						 String eventstartdate, String eventenddate,
						 String agelimit, String playtime, String eventplace, String eventhomepage, String usetime, String spendtime,
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
		this.eventstartdate = eventstartdate;
		this.eventenddate=eventenddate;
		this.agelimit = agelimit;
		this.playtime = playtime;
		this.eventplace = eventplace;
		this.eventhomepage = eventhomepage;
		this.usetime = usetime;
		this.spendtime = spendtime;
		this.msg = msg;
	}
}
