package com.hwadee.SecondHandHouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.SecondHandHouse.entity.District;
import com.hwadee.SecondHandHouse.service.interfaces.DistrictService;

@Controller
@RequestMapping("/district")
public class DistrictController {
	
	@Autowired
	private DistrictService districtservice;
	
	@RequestMapping("/finddistrictbyareaid/{areaId}")
	public @ResponseBody List<District> findchildrenbyid(@PathVariable("areaId") int areaId )
	{
		List<District> dlist = null;
		try {
			dlist = districtservice.finddistrictbyareaid(areaId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}
	
	@RequestMapping("/findbyname/{districtName}")
	public @ResponseBody List<District> findbyname(@PathVariable("districtName") String districtName )
	{
		List<District> sdlist = districtservice.findbyname(districtName);
		return sdlist;
	}
	
	@RequestMapping("/finddistrictbydistrictid/{districtId}")
	public @ResponseBody District finddistrictbydistrictid(@PathVariable("districtId") int districtId ){
		District district = districtservice.finddistrictbydistrictid(districtId);
		return district;
	}
	
	@RequestMapping(value="/savedistrictinfo", method=RequestMethod.POST)
	public @ResponseBody int savedistrictinfo(District district )
	{
		if(district.getDistrictId()==0)
		{
			return 1;
		}
		int result = districtservice.updatedis(district);
		return result;
	}
	
	@RequestMapping(value="/adddistrictinfo", method=RequestMethod.POST)
	public @ResponseBody int adddistrictinfo(District district )
	{
		int result;
		if( districtservice.isexist(district.getDistrictName(),districtservice.finddistrictbyareaid(district.getAreaId())) )
		{
			result = 0;
		}
		else
		{
			result = districtservice.adddistrict(district);
		}
		return result;
	}
}
