package com.hwadee.SecondHandHouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.SecondHandHouse.dao.AreaDao;
import com.hwadee.SecondHandHouse.entity.Area;
import com.hwadee.SecondHandHouse.service.interfaces.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDao areadao;
	
	
	public List<Area> findareabycityid(int cityId) {
		// TODO Auto-generated method stub
		
		List<Area> alist = areadao.findareabycityid(cityId);
		
		return alist;
	}

}
