package com.mb11.application.service.sport;

import java.text.ParseException;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntitySportAPIServiceTest {

	@Autowired
	CricSportSyncService cricSportSyncService;

	@Test
	public void getSeriesAndTeams() throws JSONException, ParseException {

		cricSportSyncService.syncSeriesTeamsMatchAndPlayers("201819");
	}

}
