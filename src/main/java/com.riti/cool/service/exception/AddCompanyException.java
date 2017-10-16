package com.riti.cool.service.exception;


public class AddCompanyException extends RuntimeException {
	private static final long serialVersionUID = 2435296194529486206L;

	public AddCompanyException() {
	}

	public AddCompanyException(String message) {
		super(message);
	}

	public AddCompanyException(Throwable cause) {
		super(cause);
	}

	public AddCompanyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
