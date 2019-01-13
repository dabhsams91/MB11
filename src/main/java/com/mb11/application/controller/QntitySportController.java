package com.mb11.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb11.application.payload.ApiResponse;
import com.mb11.application.service.QntitySportAPIService;

@RestController
@RequestMapping("/cricapi")
public class QntitySportController {
	
	@Autowired
	QntitySportAPIService sportAPIService;
	
	@GetMapping("/competitions")
	public ResponseEntity<?> getCompetitionsList(){
		
		sportAPIService.getCompetitionsList();
		
		return ResponseEntity.ok(new ApiResponse(true, "Get successfully"));
	}

}
