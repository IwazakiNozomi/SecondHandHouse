package com.hwadee.SecondHandHouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.SecondHandHouse.dao.DistrictDao;
import com.hwadee.SecondHandHouse.entity.District;
import com.hwadee.SecondHandHouse.service.interfaces.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	DistrictDao districtdao;
	
	public List<District> finddistrictbyareaid(int areaId) {
		// TODO Auto-generated method stub
		
		List<District> dlist = districtdao.finddistrictbyareaid(areaId);
		
		return dlist;
	}

}
