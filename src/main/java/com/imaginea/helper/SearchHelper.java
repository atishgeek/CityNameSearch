package com.imaginea.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imaginea.dto.CitySearchDto;

/**
 * Helper class for conversion and other smaller tasks
 * 
 * @author atishv
 *
 */
@Component
public class SearchHelper {

	public CitySearchDto convertRequestParamToDto(String name, int range) {
		CitySearchDto dto = new CitySearchDto();
		dto.setMaxLimit(range);
		dto.setCityName(name);
		
		return dto;
	}

	public List<String> shortListCityNamesAsPerRequest(CitySearchDto dto) {

		int range = dto.getMaxLimit();
		List<String> cityList = dto.getCityList();
		String cityName = dto.getCityName();

		// sort the list
		Collections.sort(cityList);
		
		// Get the list of all the matched values 
		List<String> matchedCityList = new ArrayList<>();
		
		for (String string : cityList) {
			if(string.toUpperCase().matches(cityName.toUpperCase()+".*")) {
				matchedCityList.add(string);
			}
		}
		
		// Shortlist the requested city name with range
		List<String> resultCityList = new ArrayList<>();
		
		if(null!=matchedCityList  && !matchedCityList.isEmpty()) {
			for (int i = 0; i <= range-1 && i < matchedCityList.size(); i++) {
				resultCityList.add(matchedCityList.get(i));
			}
		}
		return resultCityList;
	}

	public String convertResultToString(List<String> cityList) {
		String result = null;
		if(null!=cityList && !cityList.isEmpty()) {
			for (String string : cityList) {
				if(result==null) {
					result = string;
				}else {
					result = result + "<br>"  +string;
				}
			}
		}else {
			result = "No Results found, try with other parameters";
		}
		return result;
	}

	
	
}
