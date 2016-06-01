package com.hwadee.SecondHandHouse.dao;

import java.util.List;

import com.hwadee.SecondHandHouse.entity.District;

public interface DistrictDao {
	//查找该城区所属的片区
	List<District> finddistrictbyareaid(int areaId);
}
