package com.riti.cool.service.exception;

public class TagListException extends RuntimeException {
	private static final long serialVersionUID = 6180191103842028379L;

	public TagListException() {
	}

	public TagListException(String message) {
		super(message);
	}

	public TagListException(Throwable cause) {
		super(cause);
	}

	public TagListException(String message, Throwable cause) {
		super(message, cause);
	}

	public TagListException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
