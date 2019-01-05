package com.mb11.application.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationProcessingException extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationProcessingException(String msg) {
        super(msg);
    }
}
