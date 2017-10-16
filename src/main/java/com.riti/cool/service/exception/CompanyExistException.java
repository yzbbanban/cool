package com.riti.cool.service.exception;


public class CompanyExistException extends RuntimeException {
	private static final long serialVersionUID = 3435296194529486206L;

	public CompanyExistException() {
	}

	public CompanyExistException(String message) {
		super(message);
	}

	public CompanyExistException(Throwable cause) {
		super(cause);
	}

	public CompanyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompanyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
