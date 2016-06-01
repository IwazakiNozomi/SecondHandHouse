package com.hwadee.SecondHandHouse.service.interfaces;

import java.util.List;

import com.hwadee.SecondHandHouse.entity.District;

public interface DistrictService {
	//查找属于该城区的所有片区
	List<District> finddistrictbyareaid(int areaId);
}
