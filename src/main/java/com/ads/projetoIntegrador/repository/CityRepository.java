package com.ads.projetoIntegrador.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ads.projetoIntegrador.entity.CityEntity;

public class CityRepository extends AbstractRepository<CityEntity, Integer> {

	public CityRepository() {
		super(CityEntity.class);
	}
	
	public List<CityEntity> findByState(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return super.find(CityEntity.FIND_BY_STATE, params);
	}
	
}