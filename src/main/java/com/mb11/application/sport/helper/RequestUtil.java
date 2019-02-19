package com.mb11.application.sport.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class RequestUtil {

	public static HttpHeaders getReqHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

}
