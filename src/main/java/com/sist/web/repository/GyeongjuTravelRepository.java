package com.sist.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sist.web.dto.TravelListDTO;
import com.sist.web.entity.GyeongjuTravel;
@Repository
public interface GyeongjuTravelRepository extends JpaRepository<GyeongjuTravel, Integer>{
	@Query("SELECT new com.sist.web.dto.TravelListDTO(b.title, b.image1, b.contentid, b.address, b.contenttype, b.hit) FROM GyeongjuTravel b WHERE b.contenttype = :contenttype ORDER BY b.contentid ASC")
	Page<TravelListDTO> GyeongjuListData(@Param("contenttype")int contenttype,Pageable pageable);
}
