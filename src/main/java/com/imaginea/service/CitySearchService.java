package com.imaginea.service;

import java.util.List;

import com.imaginea.dto.CitySearchDto;

public interface CitySearchService {

	List<String> findSimilarNames(CitySearchDto dto);

}
