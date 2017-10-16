package com.riti.rfid.service.exception;

public class RfidUserException extends RuntimeException {
	private static final long serialVersionUID = 4440191103842028379L;

	public RfidUserException() {
	}

	public RfidUserException(String message) {
		super(message);
	}

	public RfidUserException(Throwable cause) {
		super(cause);
	}

	public RfidUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public RfidUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
