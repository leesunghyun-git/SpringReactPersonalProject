package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class ShoppingDTO extends TravelDetailDTO{
	/*
	 * NO bigint 
CONTENTID bigint 
SALEITEM varchar(1024) 
SALEITEMCOST varchar(1024) 
FAIRDAY varchar(1024) 
INFOCENTER varchar(1024) 
RESTDATE varchar(1024) 
PARKING varchar(1024) 
OPENTIME varchar(1024) 
MSG longblob
	 */
	private String saleitem;
	private String saleitemcost;
	private String fairday;
	private String infocenter;
	private String restdate;
	private String parking;
	private String opentime;
	private String msg;

	public ShoppingDTO(String title, String image1, double x, double y, int contentid,
	                    String address, int contenttype, int hit,
						String saleitem, String saleitemcost, String fairday, String infocenter, String restdate, String parking, String opentime,
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
		this.saleitem = saleitem;
		this.saleitemcost = saleitemcost;
		this.fairday = fairday;
		this.infocenter = infocenter;
		this.restdate = restdate;
		this.parking = parking;
		this.opentime = opentime;
		this.msg = msg;
	}
}
