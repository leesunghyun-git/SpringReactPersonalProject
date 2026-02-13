package com.sist.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CultureDTO;
import com.sist.web.dto.FestivalDTO;
import com.sist.web.dto.FoodStoreDTO;
import com.sist.web.dto.ShoppingDTO;
import com.sist.web.dto.StayDTO;
import com.sist.web.dto.TravelListDTO;
import com.sist.web.repository.BusanTravelRepository;
import com.sist.web.repository.GyeongjuTravelRepository;
import com.sist.web.repository.JejuTravelRepository;
import com.sist.web.repository.SeoulTravelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService{
	private final SeoulTravelRepository sRepo;
	private final GyeongjuTravelRepository gRepo;
	private final BusanTravelRepository bRepo;
	private final JejuTravelRepository jRepo;
	
	@Override
	public AttractionDTO travelAttrData(String region, int contentid) {
		// TODO Auto-generated method stub
		AttractionDTO dto = null;
		switch (region) {
		case "seoul": {
			
			dto=sRepo.seoulAttrDetail(contentid);
			break;
		}
		case "busan": {
			dto=bRepo.busanAttrDetail(contentid);
			break;
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuAttrDetail(contentid);
			break;
		}
		case "jeju": {
			dto=jRepo.jejuAttrDetail(contentid);
			break;
		}
		}
		return dto;
	}
	@Override
	public CultureDTO travelCultData(String region, int contentid) {
		// TODO Auto-generated method stub
		CultureDTO dto = null;
		switch (region) {
		case "seoul": {
			
			dto=sRepo.seoulCultDetail(contentid);
			break;
		}
		case "busan": {
			dto=bRepo.busanCultDetail(contentid);
			break;
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuCultDetail(contentid);
			break;
		}
		case "jeju": {
			dto=jRepo.jejuCultDetail(contentid);
			break;
		}
		}
		return dto;
	}
	@Override
	public FestivalDTO travelFesData(String region, int contentid) {
		// TODO Auto-generated method stub
		FestivalDTO dto = null;
		switch (region) {
		case "seoul": {
			
			dto=sRepo.seoulFesDetail(contentid);
			break;
		}
		case "busan": {
			dto=bRepo.busanFesDetail(contentid);
			break;
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuFesDetail(contentid);
			break;
		}
		case "jeju": {
			dto=jRepo.jejuFesDetail(contentid);
			break;
		}
		}
		return dto;
	}
	@Override
	public FoodStoreDTO travelFoodData(String region, int contentid) {
		// TODO Auto-generated method stub
		FoodStoreDTO dto = null;
		switch (region) {
		case "seoul": {
			
			dto=sRepo.seoulFoodDetail(contentid);
			break;
			
		}
		case "busan": {
			dto=bRepo.busanFoodDetail(contentid);
			break;
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuFoodDetail(contentid);
			break;
		}
		case "jeju": {
			dto=jRepo.jejuFoodDetail(contentid);
			break;
		}
		}
		return dto;
	}
	@Override
	public Page<TravelListDTO> travelListData(String region, int contenttype, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<TravelListDTO> list = null;
		switch (region) {
		case "seoul": {
			
			list=sRepo.SeoulListData(contenttype, pageable);
			break;
			
		}
		case "busan": {
			list=bRepo.busanListData(contenttype, pageable);
			break;
		}
		case "gyeongju": {
			list = gRepo.gyeongjuListData(contenttype, pageable);
			break;
		}
		case "jeju": {
			list = jRepo.JejuListData(contenttype, pageable);
			break;
			}
		}
		return list;
	}
	@Override
	public ShoppingDTO travelShopData(String region, int contentid) {
		// TODO Auto-generated method stub
		ShoppingDTO dto = null;
		switch (region) {
		case "seoul": {
			dto=sRepo.seoulShopDetail(contentid);	
		}
		case "busan": {
			dto=bRepo.busanShopDetail(contentid);
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuShopDetail(contentid);
		}
		case "jeju": {
			dto=jRepo.jejuShopDetail(contentid);
		}
		}
		return dto;
	}
	
	@Override
	public StayDTO travelStayData(String region, int contentid) {
		// TODO Auto-generated method stub
		StayDTO dto = null;
		switch (region) {
		case "seoul": {
			dto=sRepo.seoulStayDetail(contentid);	
			break;
		}
		case "busan": {
			dto=bRepo.busanStayDetail(contentid);
			break;
		}
		case "gyeongju": {
			dto=gRepo.gyeongjuStayDetail(contentid);
			break;
		}
		case "jeju": {
			dto=jRepo.jejuStayDetail(contentid);
			break;
		}
		}
		return dto;
	}
}
