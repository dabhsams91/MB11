package com.mb11.application.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb11.application.payload.ApiResponse;
import com.mb11.application.payload.admin.sport.Series;
import com.mb11.application.service.sport.EntitySportAPIService;

@RestController
@RequestMapping("/cricapi")
public class AdminSportController {

	@Autowired
	EntitySportAPIService sportAPIService;

	@GetMapping("/series")
	public ResponseEntity<?> getSeriesBtnTime(Date toDate, Date fromDate) throws JSONException, ParseException {

		sportAPIService.getSeries("2018");
		List<Series> seriesList = new ArrayList<>();
		Series series = new Series();
		series.setObjId(10);
		series.setLink("/10");
		seriesList.add(series);
		series.setDisplayName("Bodar gavasakar trophy");
		series.setMatchlistLink("");
		series.setTeamlistLink("");
		ApiResponse apiResponse = new ApiResponse(true, "Series list data fetch successfully");
		apiResponse.setResponse(seriesList);

		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/series/{id}")
	public ResponseEntity<?> getSeriesBtnTime(@PathParam("id") Long id) {

		Series series = new Series();
		series.setObjId(10);
		series.setLink("/");
		ApiResponse apiResponse = new ApiResponse(true, "Series data fetch successfully");
		apiResponse.setResponse(series);
		return ResponseEntity.ok(apiResponse);
	}

}
