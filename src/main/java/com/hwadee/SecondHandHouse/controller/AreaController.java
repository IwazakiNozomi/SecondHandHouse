package com.hwadee.SecondHandHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.SecondHandHouse.entity.Area;
import com.hwadee.SecondHandHouse.service.interfaces.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private AreaService areaservice;
	
	@RequestMapping("/findareabycityid/{cityId}")
	public @ResponseBody List<Area> findareabycityid( @PathVariable("cityId") int cityId )
	{
		
		List<Area> alist = areaservice.findareabycityid(cityId);
		
		return alist;
	}
}
