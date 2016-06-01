package com.hwadee.SecondHandHouse.service.interfaces;

import java.util.List;

import com.hwadee.SecondHandHouse.entity.Area;

public interface AreaService {
	//根据城市查找城区
	List<Area> findareabycityid(int cityId);
}
