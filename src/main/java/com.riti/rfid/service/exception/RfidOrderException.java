package com.riti.rfid.service.exception;

public class RfidOrderException extends RuntimeException {
	private static final long serialVersionUID = 5000191103842028379L;

	public RfidOrderException() {
	}

	public RfidOrderException(String message) {
		super(message);
	}

	public RfidOrderException(Throwable cause) {
		super(cause);
	}

	public RfidOrderException(String message, Throwable cause) {
		super(message, cause);
	}

	public RfidOrderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
