package com.mb11.application.service.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mb11.application.config.RestTemplateConfig;

import net.minidev.json.JSONObject;

@Service
public class QntitySportAPIService {

	@Autowired
    RestTemplate restTemplate;
	
	private String competitionsUrl = "competitions";

	public void getSeries() {
		
		StringBuilder baseUrl = RestTemplateConfig.getBaseURL();
		baseUrl.append("/"+competitionsUrl);
		baseUrl.append("?token="+RestTemplateConfig.apiTocken);
		
		JSONObject jsonObject = restTemplate.getForObject(baseUrl.toString(), JSONObject.class);
		
		System.out.println(jsonObject.toJSONString());
		
	}
}
