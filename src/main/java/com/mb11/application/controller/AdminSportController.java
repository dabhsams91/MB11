package com.mb11.application.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb11.application.controller.cricapidata.SeriesNotFoundException;
import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.Series;
import com.mb11.application.model.cricapidata.TeamPlayers;
import com.mb11.application.payload.ApiResponse;
import com.mb11.application.payload.admin.sport.service.MatchService;
import com.mb11.application.payload.admin.sport.service.PlayerService;
import com.mb11.application.payload.admin.sport.service.SeriesService;
import com.mb11.application.payload.admin.sport.service.TeamService;
//import com.mb11.application.payload.admin.sport.Series;
import com.mb11.application.service.sport.CricSportSyncService;
import com.mb11.application.service.sport.EntitySportAPIService;

@RestController
@RequestMapping("/cricapi")
public class AdminSportController {
	
	
	@Autowired
	private SeriesRepository sr;
	
	@Autowired
	private MTeamRepository mr;
	
	@Autowired
	private MatchRepository mrp;
	
	@Autowired
	private TeamPlayersRepository tmr;
	
	@Autowired
	private com.mb11.application.payload.admin.sport.Series adminSeries;
	
	@Autowired
	private SeriesService seriesService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MatchService matchServiace;
	
	@Autowired
	private PlayerService playerService;
	
	 
	
	@GetMapping("/series")
	public ResponseEntity<?> retrieveAllSeries() {

		List<com.mb11.application.payload.admin.sport.Series> asl=seriesService.getAllSeries();

		ApiResponse apiResponse = new ApiResponse(true, "Series data fetch successfully");
		apiResponse.setResponse(asl);
		return ResponseEntity.ok(apiResponse);
	
	}

	@GetMapping("/series/{id}")
	public ResponseEntity<?> retrieveSeries(@PathVariable String id) {
		com.mb11.application.payload.admin.sport.Series adminSeries=seriesService.getSeriesBySeriesID(id);
		
		ApiResponse apiResponse = new ApiResponse(true, "Single Series data fetch successfully");
		apiResponse.setResponse(adminSeries);
		return ResponseEntity.ok(apiResponse);
		
	
	}
	
	@GetMapping("/teams")
	public ResponseEntity<?> retrieveAllTeams() {
		
		ApiResponse apiResponse = new ApiResponse(true, "Team data fetch successfully");
		apiResponse.setResponse(teamService.getAllTeams());
		return ResponseEntity.ok(apiResponse);
		
	}
	
	@GetMapping("/teams/{id}")
	public ResponseEntity<?> retrieveUser(@PathVariable Long id) {
		ApiResponse apiResponse = new ApiResponse(true, "Single Team data fetch successfully");
		apiResponse.setResponse(teamService.getTeamsByTeamId(id));
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/matches")
	public ResponseEntity<?> retrieveAllMatches() {
		
		ApiResponse apiResponse = new ApiResponse(true, "Match data fetch successfully");
		apiResponse.setResponse(matchServiace.getAllMatches());
		return ResponseEntity.ok(apiResponse);
	}
	
	
	@GetMapping("/matches/{id}")
	public ResponseEntity<?> retrieveMatch(@PathVariable Long id) {
		ApiResponse apiResponse = new ApiResponse(true, "Single Match data fetch successfully");
		apiResponse.setResponse(matchServiace.getMatchByMatchId(id));
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/players")
	public ResponseEntity<?> retrieveAllPlayers() {
		ApiResponse apiResponse = new ApiResponse(true, "Player data fetch successfully");
		apiResponse.setResponse(playerService.getAllPlayers());
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/players/{id}")
	public ResponseEntity<?> retrievePlayer(@PathVariable Long id) {
		ApiResponse apiResponse = new ApiResponse(true, "Single Player data fetch successfully");
		apiResponse.setResponse(playerService.getAllPlayersByPlayerId(id));
		return ResponseEntity.ok(apiResponse);
	}
	
	
	
	

	@Autowired
	CricSportSyncService cricSportSyncService;

	
	public ResponseEntity<?> syncSeriesAndTeam(Date toDate, Date fromDate) throws JSONException {

		cricSportSyncService.syncSeriesTeamsMatchAndPlayers("");
		ApiResponse apiResponse = new ApiResponse(true, "Data sync successfully");

		return ResponseEntity.ok(apiResponse);
	}

}
