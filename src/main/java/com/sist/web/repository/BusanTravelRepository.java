package com.sist.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.TravelListDTO;
import com.sist.web.entity.BusanTravel;
@Repository
public interface BusanTravelRepository extends JpaRepository<BusanTravel, Integer>{
	@Query("SELECT new com.sist.web.dto.TravelListDTO(b.title, b.image1, b.contentid, b.address, b.contenttype, b.hit) FROM BusanTravel b WHERE b.contenttype = :contenttype ORDER BY b.contentid ASC")
	Page<TravelListDTO> busanListData(@Param("contenttype")int contenttype,Pageable pageable);
	/*
	 * 	private String title;
	private String image1;
	private double x;
	private double y;
	private int contentid;
	private String address;
	private int contenttype;
	private int hit;
	
	 * 	private String infocenter;
	private String resdate;
	private String usetime;
	private String pakring;
	private String msg;
	 */
	@Query(value="SELECT title,image1,x,y,b.contentid,addresss,contenttype,hit,infocenter,restdate,usertime,parking,msg FROM BusanTravel b JOIN Attraction a ON b.contentid = a.contentid WHERE b.contentid = :contentid",nativeQuery = true)
	AttractionDTO buanAttrDetail(@Param("contentid")int contentid);
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
}
