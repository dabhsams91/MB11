package com.mb11.application.controller.cricapidata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeriesNotFoundException extends RuntimeException {

	public SeriesNotFoundException(String message) {
		super(message);
	}
}
