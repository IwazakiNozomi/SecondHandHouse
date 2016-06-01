package com.hwadee.SecondHandHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.SecondHandHouse.entity.City;
import com.hwadee.SecondHandHouse.entity.District;
import com.hwadee.SecondHandHouse.service.interfaces.DistrictService;

@Controller
@RequestMapping("/district")
public class DistrictController {
	
	@Autowired
	private DistrictService districtservice;
	
	@RequestMapping("/finddistrictbyareaid/{areaId}")
	public @ResponseBody List<District> findchildrenbyid(@PathVariable("areaId") int areaId ){
		
		
		
		List<District> dlist = null;
		try {
			dlist = districtservice.finddistrictbyareaid(areaId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}
	
	
}
