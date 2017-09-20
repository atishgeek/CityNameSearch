package com.imaginea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.imaginea.dto.CitySearchDto;
import com.imaginea.helper.SearchHelper;
import com.imaginea.service.CitySearchService;

/**
 * Controller class to handle the incoming request
 * 
 * @author atishv
 *
 */
@Controller
public class CitySearchController extends  ResponseEntityExceptionHandler{

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
	public String suggestCities(@RequestParam(name="start")String name ,@RequestParam(name="atmost")int range) {
		String result = "";
		CitySearchDto dto = helper.convertRequestParamToDto(name,range);
		
		List<String> cityList = searchService.findSimilarNames(dto);
		
		if(null!=name || range!=0) {
			result = helper.convertResultToString(cityList);
		}else {
			result = "Bad Parameters";
		}
		
		return result;
	}

}
