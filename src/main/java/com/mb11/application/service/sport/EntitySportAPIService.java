package com.mb11.application.service.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mb11.application.config.RestTemplateConfig;
import com.mb11.application.payload.admin.sport.Series;

import net.minidev.json.JSONObject;

@Service
public class EntitySportAPIService {

	@Autowired
    RestTemplate restTemplate;
	
	private String competitionsUrl = "competitions";

	public List<Series> getSeries() {
		
		
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/"+competitionsUrl);
		baseUrl.append("?token="+RestTemplateConfig.apiTocken);
		
		JSONObject jsonObject = restTemplate.getForObject(baseUrl.toString(), JSONObject.class);
		
		System.out.println(jsonObject.toJSONString());
		
		return null;
		
	}
}
