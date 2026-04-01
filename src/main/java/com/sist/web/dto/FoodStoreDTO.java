package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
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

	public FoodStoreDTO(String title, String image1, double x, double y, int contentid,
	                   String address, int contenttype, int hit,
					   String firstmenu, String treatmenu, String infocenter, String parking, String opendate, String opentime, String restdate,
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
		this.firstmenu = firstmenu;
		this.treatmenu= treatmenu;
		this.infocenter = infocenter;
		this.parking= parking;
		this.opendate=opendate;
		this.opentime = opentime;
		this.restdate = restdate;
		this.msg = msg;
	}
}
