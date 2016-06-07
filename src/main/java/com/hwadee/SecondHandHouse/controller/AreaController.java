package com.hwadee.SecondHandHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.SecondHandHouse.entity.Area;
import com.hwadee.SecondHandHouse.entity.District;
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
	
	@RequestMapping("/findbyname/{areaName}")
	public @ResponseBody List<Area> findbyname( @PathVariable("areaName") String areaName )
	{
		
		List<Area> salist = areaservice.searcharea(areaName);
		
		return salist;
	}
	
	@RequestMapping("/deletearea/{areaId}")
	public @ResponseBody int deletearea( @PathVariable("areaId") int areaId )
	{
		
		int result = areaservice.deletearea(areaId);
		
		return result;
	}
	
	@RequestMapping(value="/updatearea", method=RequestMethod.POST)
	public @ResponseBody int updatearea(Area area )
	{
		int result = areaservice.updatearea(area);
		return result;
	}
	
	@RequestMapping(value="/addarea", method=RequestMethod.POST)
	public @ResponseBody int adddistrictinfo(Area area )
	{
		int result = 0;
		if( areaservice.isexist( area.getAreaName() , areaservice.findareabycityid( area.getCityId() ) )  )
		{
			result = 0;
		}
		else
		{
			result = areaservice.addarea(area);
		}
		return result;
	}
}
