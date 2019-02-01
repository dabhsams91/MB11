package com.mb11.application.service.sport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.Series;
import com.mb11.application.model.cricapidata.Sporttype;
import com.mb11.application.model.cricapidata.TeamPlayers;
import com.mb11.application.sport.helper.RequestUtil;
import com.mb11.application.sport.helper.SportAPIHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class EntitySportAPIService.
 */
@Service
public class EntitySportAPIService {

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The api helper. */
	@Autowired
	private SportAPIHelper apiHelper;

	/** The cric sportservice. */
	@Autowired
	private CricSportService cricSportservice;

	/**
	 * Gets the series and teams.
	 *
	 * @param year the year
	 * @return the series and teams
	 * @throws JSONException  the JSON exception
	 * @throws ParseException the parse exception
	 */
	public List<Series> getSeriesAndTeams(String year) throws JSONException, ParseException {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getSeriesApi(year), HttpMethod.GET, entity,
				String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Response is-----  " + myResponse);

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("items");
		System.out.println("JSON ARRAY IS........ " + jsonResults);
		List<Series> lseries = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
			Date startdate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("datestart"));
			Date enddate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("dateend"));
			Long cid = jsonResults.getJSONObject(i).getLong("cid");

			lseries.add(new Series(Long.toString(cid), jsonResults.getJSONObject(i).getString("title"),
					jsonResults.getJSONObject(i).getString("abbr"), jsonResults.getJSONObject(i).getString("category"),
					startdate, enddate, jsonResults.getJSONObject(i).getInt("total_matches"),
					jsonResults.getJSONObject(i).getInt("total_teams"), false,
					cricSportservice.getTeamsWithSet(Long.valueOf(cid))));

		}

		return lseries;

	}

	/**
	 * Gets the series.
	 *
	 * @param year the year
	 * @return the series
	 * @throws JSONException  the JSON exception
	 * @throws ParseException the parse exception
	 */
	public List<Series> getSeries(String year) throws JSONException, ParseException {

		String url = apiHelper.getSeriesApi(year);

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Response is-----  " + myResponse);

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("items");
		System.out.println("JSON ARRAY IS........ " + jsonResults);
		List<Series> lseries = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
			Date startdate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("datestart"));
			Date enddate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("dateend"));
			Long cid = jsonResults.getJSONObject(i).getLong("cid");
			lseries.add(new Series(Long.toString(cid), jsonResults.getJSONObject(i).getString("title"),
					jsonResults.getJSONObject(i).getString("abbr"), jsonResults.getJSONObject(i).getString("category"),
					startdate, enddate, jsonResults.getJSONObject(i).getInt("total_matches"),
					jsonResults.getJSONObject(i).getInt("total_teams"), false));

		}

		return lseries;

	}

	/**
	 * Gets the teams.
	 *
	 * @param id the id
	 * @return the teams
	 */
	public List<MTeam> getTeams(Long id) {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getTeamsApi(id), HttpMethod.GET, entity,
				String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Response is-----  " + myResponse);

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("teams");
		System.out.println("JSON ARRAY IS........ " + jsonResults);
		List<MTeam> lteams = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {

			lteams.add(new MTeam(jsonResults.getJSONObject(i).getLong("tid"),
					jsonResults.getJSONObject(i).getString("title"), jsonResults.getJSONObject(i).getString("abbr"),
					jsonResults.getJSONObject(i).getString("logo_url"), jsonResults.getJSONObject(i).getString("sex"),
					Sporttype.Cricket, null

			));

		}

		return lteams;

	}

	/**
	 * Gets the matches.
	 *
	 * @param id the id
	 * @return the matches
	 * @throws JSONException  the JSON exception
	 * @throws ParseException the parse exception
	 */
	public List<Match> getMatches(Long id) throws JSONException, ParseException {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getMatchesApi(id), HttpMethod.GET, entity,
				String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Match API Response is-----  " + myResponse);
		System.out.println();

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("items");
		System.out.println("MATCH JSON ARRAY IS........ " + jsonResults);
		List<Match> lMatch = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
			Date startdate = (Date) formatter
					.parse(jsonResults.getJSONObject(i).getJSONObject("competition").getString("datestart"));
			Date enddate = (Date) formatter
					.parse(jsonResults.getJSONObject(i).getJSONObject("competition").getString("dateend"));
			Long cid = jsonResults.getJSONObject(i).getJSONObject("competition").getLong("cid");

			lMatch.add(new Match(

					jsonResults.getJSONObject(i).getLong("match_id"), jsonResults.getJSONObject(i).getString("title"),
					jsonResults.getJSONObject(i).getString("format_str"),
					jsonResults.getJSONObject(i).getString("status_str"),
					new Series(Long.toString(cid),
							jsonResults.getJSONObject(i).getJSONObject("competition").getString("title"),
							jsonResults.getJSONObject(i).getJSONObject("competition").getString("abbr"),
							jsonResults.getJSONObject(i).getJSONObject("competition").getString("category"), startdate,
							enddate, jsonResults.getJSONObject(i).getJSONObject("competition").getInt("total_matches"),
							jsonResults.getJSONObject(i).getJSONObject("competition").getInt("total_teams"), false,
							cricSportservice.getTeamsWithSet(Long.valueOf(cid)

							))));

		}

		return lMatch;

	}

	/**
	 * Gets the team players.
	 *
	 * @param id the id
	 * @return the team players
	 */
	public List<TeamPlayers> getTeamPlayers(Long id) {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getPlayersApi(id), HttpMethod.GET, entity,
				String.class);
		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("TeamPlayers API Response is-----  " + myResponse);
		System.out.println();

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("squads");

		System.out.println("TeamPlayers JSON ARRAY IS........ " + jsonResults);

		List<TeamPlayers> lTeamPlayers = new ArrayList<>();

		MTeam lteams = null;

		for (int i = 0; i < jsonResults.length(); i++) {

			lteams = new MTeam(jsonResults.getJSONObject(i).getLong("tid"),
					jsonResults.getJSONObject(i).getString("title"), jsonResults.getJSONObject(i).getString("abbr"),
					jsonResults.getJSONObject(i).getString("logo_url"), jsonResults.getJSONObject(i).getString("sex"),
					Sporttype.Cricket, null

			);

			JSONObject playesrObject = jsonResults.getJSONObject(i);
			JSONArray playesrArray = playesrObject.getJSONArray("players");
			for (int j = 0; j < playesrArray.length(); j++) {

				lTeamPlayers.add(new TeamPlayers(

						playesrArray.getJSONObject(j).getLong("pid"),
						playesrArray.getJSONObject(j).getString("first_name"),
						playesrArray.getJSONObject(j).getString("middle_name"),
						playesrArray.getJSONObject(j).getString("last_name"), lteams // will have to update this line

				));

			}

		}

		return lTeamPlayers;

	}

}
