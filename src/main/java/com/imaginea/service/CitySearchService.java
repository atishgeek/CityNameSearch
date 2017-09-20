package com.imaginea.service;

import com.imaginea.dto.CitySearchDto;
import com.imaginea.dto.ResponseDto;

public interface CitySearchService {

	public ResponseDto findSimilarNames(CitySearchDto dto);

}
