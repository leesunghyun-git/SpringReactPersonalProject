package com.sist.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ShoppingDTO {
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
}
