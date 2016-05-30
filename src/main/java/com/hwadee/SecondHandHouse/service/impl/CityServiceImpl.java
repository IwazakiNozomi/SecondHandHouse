package com.hwadee.SecondHandHouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.SecondHandHouse.dao.CityDao;
import com.hwadee.SecondHandHouse.entity.City;
import com.hwadee.SecondHandHouse.service.interfaces.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao citydao;
	
	public int add( City city ) {
		// TODO Auto-generated method stub
		
		citydao.addcity(city);
		
		return 0;
	}

}
