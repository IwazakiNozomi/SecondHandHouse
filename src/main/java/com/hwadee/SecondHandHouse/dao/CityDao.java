package com.hwadee.SecondHandHouse.dao;

import java.util.List;

import com.hwadee.SecondHandHouse.entity.City;

public interface CityDao {
	//添加city
	int addcity( City city );
	
	//按id查找
	City findbyid( int cityId );
	//根据父id查找子城市
	List<City> findchildrenbyid(int cityId);
	//查找所有
	List<City> findall();
	
}
