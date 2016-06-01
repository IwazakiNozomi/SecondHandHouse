package com.hwadee.SecondHandHouse.dao;

import java.util.List;

import com.hwadee.SecondHandHouse.entity.Area;

public interface AreaDao {
	//查到城市的城区
	List<Area> findareabycityid(int cityId);
}
