package com.sist.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CultureDTO;
import com.sist.web.dto.FestivalDTO;
import com.sist.web.dto.FoodStoreDTO;
import com.sist.web.dto.ShoppingDTO;
import com.sist.web.dto.StayDTO;
import com.sist.web.dto.TravelListDTO;
import com.sist.web.entity.SeoulTravel;
@Repository
public interface SeoulTravelRepository extends JpaRepository<SeoulTravel, Integer>{
	@Query("SELECT new com.sist.web.dto.TravelListDTO(b.title, b.image1, b.contentid, b.address, b.contenttype, b.hit) FROM com.sist.web.entity.SeoulTravel b WHERE b.contenttype = :contenttype ORDER BY b.contentid ASC")
	Page<TravelListDTO> SeoulListData(@Param("contenttype")int contenttype,Pageable pageable);
	
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,infocenter,restdate,usertime,parking,msg FROM seoulTravel b JOIN Attraction a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	AttractionDTO seoulAttrDetail(@Param("contentid")int contentid);
	/*
	 * 
	 *  * NO bigint 
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
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,usefee,spendtime,parkingfee,discountinfo,infocenter,usetime,restdate,parking,msg FROM seoulTravel b JOIN culture a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	CultureDTO seoulCultDetail(@Param("contentid")int contentid);
	
	/*
	 * 	private String eventstartdate;
	private String eventenddate;
	private String agelimit;
	private String playtime;
	private String eventplace;
	private String eventhomepage;
	private String usetime;
	private String spendtime;
	private String msg;
	 */
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,eventstartdate,eventenddate,agelimit,palytime,eventplace,eventhomepage,usetime,spendtime,msg FROM seoulTravel b JOIN Festival a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	FestivalDTO seoulFesDetail(@Param("contentid")int contentid);
	/*
	 * 	private String saleitem;
	private String saleitemcost;
	private String fairday;
	private String infocenter;
	private String restdate;
	private String parking;
	private String opentime;
	private String msg;
	 */
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,saleitem,saleitemcost,fairday,infocenter,restdate,parking,opentime,msg FROM seoulTravel b JOIN shopping a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	ShoppingDTO seoulShopDetail(@Param("contentid")int contentid);
	
	/*
	 * 	private String roomtype;
	private String checkingtime;
	private String checkouttime;
	private String chkcooking;
	private String subfacility;
	private String foodplace;
	private String reservationurl;
	private String infocenter;
	private String parking;
	private String msg;
	 */
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,roomtype,checkingtime,checkouttime,chkcooking,subfacility,foodplace,reservationurl,infocenter,parking,msg FROM seoulTravel b JOIN stay a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	StayDTO seoulStayDetail(@Param("contentid")int contentid);

	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,firstmenu,treatmenu,infocenter,parking,opendate,opentime,restdate,msg FROM seoulTravel b JOIN FoodStore a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	FoodStoreDTO seoulFoodDetail(@Param("contentid")int contentid);
}
