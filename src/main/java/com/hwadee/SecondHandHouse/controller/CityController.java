package com.hwadee.SecondHandHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwadee.SecondHandHouse.entity.City;
import com.hwadee.SecondHandHouse.service.interfaces.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityService cityservice;
	
	@RequestMapping("/add")
	public String addcity( City city )
	{	
		cityservice.add(city);
		return "/intermediationback/city/citytree";
	}
	
}
