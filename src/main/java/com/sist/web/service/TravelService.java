package com.sist.web.service;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.dto.*;

public interface TravelService {
	Page<TravelListDTO> travelListData(String region,int contenttype,Pageable pageable);
	AttractionDTO travelAttrData(String region,int contentid);
	CultureDTO travelCultData(String region,int contentid);
	FestivalDTO travelFesData(String region,int contentid);
	FoodStoreDTO travelFoodData(String region,int contentid);
	ShoppingDTO travelShopData(String region,int contentid);
	StayDTO travelStayData(String region,int contentid);
}
