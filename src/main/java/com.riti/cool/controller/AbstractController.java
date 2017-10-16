package com.riti.cool.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.util.ResultCode;

public abstract class AbstractController {
	/**
	 * 在其他控制器方法执行出现异常时候, 执行
	 * 异常处理方法 handleException
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleException( Exception e){
		e.printStackTrace();
		return new ResultCode(e);
	}

}
