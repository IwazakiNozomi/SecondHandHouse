package com.hwadee.SecondHandHouse.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.SecondHandHouse.entity.Area;
import com.hwadee.SecondHandHouse.entity.City;
import com.hwadee.SecondHandHouse.service.interfaces.AreaService;
import com.hwadee.SecondHandHouse.service.interfaces.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityService cityservice;
	
	@Autowired
	private AreaService areaservice;
	
	@RequestMapping("/add")
	public String addcity( City city )
	{	
		cityservice.add(city);
		return "/city/list";
	}
	
	@RequestMapping("/list")
	public String citylist( Model model )
	{
		List<City> clist = cityservice.findall();
		List<Area> alist = areaservice.findallarea();
		
		model.addAttribute("arealist", alist);
		model.addAttribute("citylist", clist);
		
		
		return "/intermediationback/city/citytree.jsp" ;
	}
	
	@RequestMapping("/findchildrenbyid/{cityId}")
	public @ResponseBody List<City> findchildrenbyid(@PathVariable("cityId") int cityId ){
		
		
		
		List<City> cclist = null;
		try {
			cclist = cityservice.findchildrenbyid(cityId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cclist;
	}
	
	@RequestMapping("/findcitybyid/{cityId}")
	public @ResponseBody City findcitybyid(@PathVariable("cityId") int cityId ){
		City city = cityservice.findbyid(cityId);
		return city;
	}
	
	@RequestMapping("/findcitybyname/{cityName}")
	public @ResponseBody List<City> findcitybyname(@PathVariable("cityName") String cityName ){
		
		List<City> sclist = cityservice.searchcity(cityName);
		return sclist;
	}
	
	@RequestMapping(value="/updatecity", method=RequestMethod.POST)
	public @ResponseBody int updatecity(City city )
	{
		int result = 0;
		if( city.getCityId() == city.getParentCityId() )
		{
			return 0 ;
		}
		else
		{
			result = cityservice.updatecity(city);
		}
		return result;
	}
}
