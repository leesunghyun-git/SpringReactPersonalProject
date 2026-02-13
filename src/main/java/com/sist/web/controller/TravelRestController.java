package com.sist.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dto.*;
import com.sist.web.service.*;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class TravelRestController {
	private final TravelService tService;
	
	@GetMapping("/{region}/list_react/{contenttype}/{page}")
	public ResponseEntity<Map> travel_list(@PathVariable("region")String region,@PathVariable("page")int page,@PathVariable("contenttype")int contenttype)
	{
		Map map =new HashMap();
		try {
			final int ROWSIZE =12;
			Pageable pageable = PageRequest.of((page-1), ROWSIZE,Sort.by(Sort.Direction.ASC,("contentid")));
			Page<TravelListDTO> pageList = tService.travelListData(region, contenttype, pageable);
			List<TravelListDTO> list = pageList.toList();
			int totalPage = pageList.getTotalPages();
			int startPage = ((page-1)/10*10)+1;
			int endPage = ((page-1)/10*10)+10;
			if(endPage>totalPage)
				endPage=totalPage;
			map.put("list", list);
			map.put("totalPage", totalPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	/*
	 * 14
		15
		32
		12
		38
		39
	 */
	@GetMapping("/{region}/detail_react/{contenttype}/{contentid}")
	public ResponseEntity<Map> travel_detail(@PathVariable("region")String region,@PathVariable("contentid")int contentid,@PathVariable("contenttype")int contenttype)
	{
		Map map =new HashMap();
		try {
			switch (contenttype) {
			case(12) : {
				AttractionDTO dto = tService.travelAttrData(region, contentid);
				map.put("dto", dto);
				break;
			}
			case(14) : {
				CultureDTO dto = tService.travelCultData(region, contentid);
				map.put("dto", dto);
				break;
			}
			case(15) : {
				FestivalDTO dto = tService.travelFesData(region, contentid);
				map.put("dto", dto);
				break;
			}
			case(32) : {
				StayDTO dto = tService.travelStayData(region, contentid);
				map.put("dto", dto);
				break;
			}
			case(38) : {
				ShoppingDTO dto = tService.travelShopData(region, contentid);
				map.put("dto", dto);
				break;
			}
			case(39) : {
				FoodStoreDTO dto = tService.travelFoodData(region, contentid);
				map.put("dto", dto);
				break;
			}
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
