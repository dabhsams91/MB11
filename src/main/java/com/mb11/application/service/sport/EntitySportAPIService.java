package com.mb11.application.service.sport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
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

	@Autowired
	private SeriesRepository seriesRepository;

	@Autowired
	private MTeamRepository teamRepository;

	@Autowired
	TeamPlayersRepository teamPlayersRepository;

	@Autowired
	MatchRepository matchRepository;

	/**
	 * Gets the series and teams.
	 *
	 * @param year the year
	 * @return the series and teams
	 * @throws JSONException  the JSON exception
	 * @throws ParseException the parse exception
	 */
	public List<Series> getSeries(String year) throws JSONException, ParseException {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getSeriesApi(year), HttpMethod.GET, entity,
				String.class);

		if (response == null || response.getBody() == null)
			return null;

		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Response is-----  " + myResponse);

		if (myResponse.getJSONObject("response") == null
				|| myResponse.getJSONObject("response").getJSONArray("items") == null)
			return null;

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("items");

		System.out.println("JSON ARRAY IS........ " + jsonResults);
		List<Series> lseries = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {

			Long cid = jsonResults.getJSONObject(i).getLong("cid");

			if (cid != null && cid >= 0) {
				String sid = Long.toString(cid);
				Series series = seriesRepository.findBySeriesid(sid);
				if (series == null) {
					series = new Series();
					series.setStatus(false);
				}
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
				Date startdate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("datestart"));
				Date enddate = (Date) formatter.parse(jsonResults.getJSONObject(i).getString("dateend"));

				series.setSeriesid(sid);
				series.setEnddate(enddate);
				series.setStartdate(startdate);
				series.setSname(jsonResults.getJSONObject(i).getString("title"));
				series.setShort_name(jsonResults.getJSONObject(i).getString("abbr"));
				series.setTotalmatch(jsonResults.getJSONObject(i).getInt("total_matches"));
				series.setCategory(jsonResults.getJSONObject(i).getString("category"));
				series.setTotalteams(jsonResults.getJSONObject(i).getInt("total_teams"));
				lseries.add(series);

			}
		}
		return lseries;

	}

	public Set<MTeam> getTeams(String seriesId) {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getTeamsApi(seriesId), HttpMethod.GET, entity,
				String.class);

		if (response == null || response.getBody() == null)
			return null;

		JSONObject myResponse = new JSONObject(response.getBody());

		if (myResponse.getJSONObject("response") == null
				|| myResponse.getJSONObject("response").getJSONArray("teams") == null)
			return null;

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
			Long tid = jsonResults.getJSONObject(i).getLong("tid");
			MTeam mTeam = teamRepository.findByTeamid(tid);
			if (mTeam == null) {
				mTeam = new MTeam();
			}

			mTeam.setLogo_url(logo_url);
			mTeam.setTeamname(jsonResults.getJSONObject(i).getString("title"));
			mTeam.setTeamabbr(jsonResults.getJSONObject(i).getString("abbr"));
			mTeam.setTeamid(tid);
			mTeam.setSporttype(Sporttype.Cricket);
			mTeam.setSex(jsonResults.getJSONObject(i).getString("sex"));

			lteams.add(mTeam);

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
	public List<Match> getMatches(String seriesId) throws JSONException, ParseException {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getMatchesApi(seriesId), HttpMethod.GET,
				entity, String.class);

		if (response == null || response.getBody() == null)
			return null;

		JSONObject myResponse = new JSONObject(response.getBody());

		System.out.println("Match API Response is-----  " + myResponse);

		if (myResponse.getJSONObject("response") == null
				|| myResponse.getJSONObject("response").getJSONArray("items") == null)
			return null;

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("items");
		System.out.println("MATCH JSON ARRAY IS........ " + jsonResults);
		List<Match> lMatch = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {

			Long matchId = jsonResults.getJSONObject(i).getLong("match_id");

			Series series = seriesRepository.findBySeriesid(seriesId);
			if (series != null) {
				Match match = matchRepository.findByMatchid(matchId);

				if (match == null) {
					match = new Match();
					match.setMatchid(matchId);
				}
				match.setMatchname(jsonResults.getJSONObject(i).getString("title"));
				match.setFormat_str(jsonResults.getJSONObject(i).getString("format_str"));
				match.setStatus_str(jsonResults.getJSONObject(i).getString("status_str"));
				match.setSid(series);
				lMatch.add(match);
			}

		}

		return lMatch;

	}

	/**
	 * Gets the team players.
	 *
	 * @param id the id
	 * @return the team players
	 */
	public List<TeamPlayers> getTeamPlayers(String seriesId) {

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(RequestUtil.getReqHeader());

		ResponseEntity<String> response = restTemplate.exchange(apiHelper.getPlayersApi(seriesId), HttpMethod.GET,
				entity, String.class);

		if (response == null || response.getBody() == null)
			return null;

		JSONObject myResponse = new JSONObject(response.getBody());

		if (myResponse.getJSONObject("response") == null
				|| myResponse.getJSONObject("response").getJSONArray("squads") == null)
			return null;

		System.out.println("TeamPlayers API Response is-----  " + myResponse);
		System.out.println();

		JSONArray jsonResults = myResponse.getJSONObject("response").getJSONArray("squads");

		System.out.println("TeamPlayers JSON ARRAY IS........ " + jsonResults);

		List<TeamPlayers> lTeamPlayers = new ArrayList<>();

		for (int i = 0; i < jsonResults.length(); i++) {

			Long teamId = jsonResults.getJSONObject(i).getLong("team_id");
			MTeam mTeam = teamRepository.findByTeamid(teamId);

			JSONObject playesrObject = jsonResults.getJSONObject(i);
			JSONArray playesrArray = playesrObject.getJSONArray("players");
			for (int j = 0; j < playesrArray.length(); j++) {

				Long playerid = playesrArray.getJSONObject(j).getLong("pid");

				TeamPlayers teamPlayers = teamPlayersRepository.findByPlayerid(playerid);
				if (teamPlayers == null) {
					teamPlayers = new TeamPlayers();
					teamPlayers.setPlayerid(playerid);
				}

				teamPlayers.setFirstname(playesrArray.getJSONObject(j).getString("first_name"));
				teamPlayers.setLastname(playesrArray.getJSONObject(j).getString("last_name"));
				teamPlayers.setMiddlename(playesrArray.getJSONObject(j).getString("middle_name"));
				teamPlayers.setmTeam(mTeam);
				lTeamPlayers.add(teamPlayers);
			}

		}

		return lTeamPlayers;

	}

}
