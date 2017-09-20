package com.imaginea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginea.dto.CitySearchDto;
import com.imaginea.dto.ResponseDto;
import com.imaginea.helper.SearchHelper;
import com.imaginea.service.CitySearchService;

/**
 * Controller class to handle the incoming request
 * 
 * @author atishv
 *
 */
@RestController
public class CitySearchController {

	@Autowired
	CitySearchService searchService;
	
	@Autowired
	SearchHelper helper;
	
	@RequestMapping(value="/")
	public String showHomePage() {
		
		return "homePage";
	}
	
	@RequestMapping(value="/suggest_cities")
	@ResponseBody
	public ResponseDto suggestCities(@RequestParam(name="start")String name ,@RequestParam(name="atmost")int range) {
		CitySearchDto dto = helper.convertRequestParamToDto(name,range);
		
		ResponseDto response = searchService.findSimilarNames(dto);
		
		return response;
	}
	

}
