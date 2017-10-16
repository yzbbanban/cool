package com.riti.cool.service.exception;


public class UserUpdateException extends RuntimeException {
	private static final long serialVersionUID = 1435296194529486206L;

	public UserUpdateException() {
	}

	public UserUpdateException(String message) {
		super(message);
	}

	public UserUpdateException(Throwable cause) {
		super(cause);
	}

	public UserUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
