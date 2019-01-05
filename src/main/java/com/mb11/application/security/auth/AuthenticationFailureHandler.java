package com.mb11.application.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.mb11.application.util.CookieUtils;

import static com.mb11.application.security.auth.HttpCookieAuthRequestRepository.PLACE_URI_PARAM_COOKIE_NAME;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	HttpCookieAuthRequestRepository httpCookieAuthRequestRepository;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String targetUrl = CookieUtils.getCookie(request, PLACE_URI_PARAM_COOKIE_NAME).map(Cookie::getValue)
				.orElse(("/"));

		targetUrl = UriComponentsBuilder.fromUriString(targetUrl).queryParam("error", exception.getLocalizedMessage())
				.build().toUriString();

		httpCookieAuthRequestRepository.removeAuthorizationRequestCookies(request, response);

		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
}
