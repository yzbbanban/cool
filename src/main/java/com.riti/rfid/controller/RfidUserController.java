package com.riti.rfid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.service.exception.MessageException;
import com.riti.rfid.entity.RfidUser;
import com.riti.rfid.service.RfidUserService;
import com.riti.rfid.service.exception.RfidUserException;
import com.riti.rfid.util.ResultCode;

@Controller
@RequestMapping("/rfidUser")
public class RfidUserController {
	@Resource
	RfidUserService service;

	/**
	 * 添加客户信息
	 * 
	 * @param rfidUser
	 * @return
	 */
	@RequestMapping(value = "/addRfidUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<RfidUser> addRfidUser(RfidUser rfidUser) {
		System.out.println(rfidUser);
		RfidUser ru = service.addRfidUserTask(rfidUser);
		return new ResultCode(ru, "添加成功");
	}
	
	@RequestMapping(value = "/addString", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<String> addString(RfidUser rfidUser) {
		System.out.println("string: "+rfidUser);
		return new ResultCode("", "添加成功");
	}

	/**
	 * 获取客户列表
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getRfidUserList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<RfidUser>> getRfidUser(String id) {
		System.out.println(id);
		List<RfidUser> ru = service.getRfidUserTask(id);
		System.out.println(ru);
		return new ResultCode(ru, "获取成功");
	}
	
	/**
	 * 获取客户列表
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getRfidUserByCompanyList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<RfidUser>> getRfidUserByCompany(String userId,String companyId,int level) {
		System.out.println(userId);
		List<RfidUser> ru = service.getRfidUserByCompanyTask( userId, companyId, level);
		System.out.println(ru);
		return new ResultCode(ru, "获取成功");
	}

	/**
	 * 更新客户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/updateRfidUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<RfidUser> updateRfidUser(RfidUser rfidUser) {
		System.out.println("updateRfidUser: "+rfidUser);
		RfidUser ru = service.updateRfidUserTask(rfidUser);
		System.out.println(ru);
		return new ResultCode(ru, "更新成功");
	}
	/**
	 * 删除客户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteRfidUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<RfidUser> deleteRfidUser(String id) {
		System.out.println("deleteRfidUser: "+id);
		RfidUser ru = service.deleteRfidUserTask(id);
		System.out.println(ru);
		return new ResultCode(ru, "删除成功");
	}
	
	
	// 添加错误
	@ExceptionHandler(RfidUserException.class)
	@ResponseBody
	public ResultCode<String> handleMessage(RfidUserException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

}
