package com.riti.rfid.util;

import java.io.Serializable;

public class ResultCode<T> implements Serializable {

//	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private T result;

	public ResultCode() {
	}
	
	public ResultCode(T result,String message){
		code = "10000";
		this.message=message;
		this.result = result;
	}
	
	public ResultCode(Throwable e) {
		this.code = "10001";
		this.message=e.getMessage();
	}
	public ResultCode(String code,Throwable e) {
		this.code = code;
		this.message=e.getMessage();
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultCode [code=" + code + ", message=" + message
				+ ", result=" + result + "]";
	}

}
