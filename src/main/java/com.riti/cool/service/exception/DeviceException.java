package com.riti.cool.service.exception;


public class DeviceException extends RuntimeException {
	private static final long serialVersionUID = 2435296194529486206L;

	public DeviceException() {
	}

	public DeviceException(String message) {
		super(message);
	}

	public DeviceException(Throwable cause) {
		super(cause);
	}

	public DeviceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
