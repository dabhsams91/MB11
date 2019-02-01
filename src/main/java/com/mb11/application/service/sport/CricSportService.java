package com.mb11.application.service.sport;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Sporttype;
import com.mb11.application.sport.helper.SportAPIHelper;

@Service
public class CricSportService {

	@Autowired
	private EntitySportAPIService es;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SportAPIHelper apiHelper;

	private HttpHeaders headers;

	private HttpEntity entity;

	private ResponseEntity<String> response;

	private String competitionsUrl;

	public Set<MTeam> getTeamsWithSet(Long id) {

		competitionsUrl = apiHelper.getTeamsApi(id);

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		entity = new HttpEntity(headers);

		response = restTemplate.exchange(competitionsUrl, HttpMethod.GET, entity, String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Response is-----  " + myResponse);

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("teams");

		System.out.println("JSON ARRAY IS........ " + jsonResults);
		Set<MTeam> lteams = new HashSet<>();
		String logo_url = "";
		for (int i = 0; i < jsonResults.length(); i++) {
			if (myResponse.has("logo_url")) {
				logo_url = jsonResults.getJSONObject(i).getString("logo_url");
			} else {
				logo_url = "";
			}

			lteams.add(new MTeam(jsonResults.getJSONObject(i).getLong("tid"),
					jsonResults.getJSONObject(i).getString("title"), jsonResults.getJSONObject(i).getString("abbr"),
					// jsonResults.getJSONObject(i).getString("logo_url"),
					logo_url, jsonResults.getJSONObject(i).getString("sex"), Sporttype.Cricket, null

			));

		}

		return lteams;

	}

}
