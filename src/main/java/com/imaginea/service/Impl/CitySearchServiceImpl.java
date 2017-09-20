package com.imaginea.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.dto.CitySearchDto;
import com.imaginea.helper.SearchHelper;
import com.imaginea.service.CitySearchService;

/**
 * This class will help us to read the content from csv file and then shortlist the requested names
 * 
 * @author atishv
 *
 */
@Service(value="searchService")
public class CitySearchServiceImpl implements CitySearchService{

	
	@Autowired
	SearchHelper helper;
	
	@Override
	public List<String> findSimilarNames(CitySearchDto dto) {
		Path path = Paths.get("src/main/resources/CityNameList.csv");
		List<String> cityList = new ArrayList<>();
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String currentLine = null;
			
			while((currentLine = reader.readLine() )!=null) {
				cityList.add(currentLine);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		dto.setCityList(cityList);
		
		return helper.shortListCityNamesAsPerRequest(dto);
	}

}
