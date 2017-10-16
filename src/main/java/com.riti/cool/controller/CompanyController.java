package com.riti.cool.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.dao.CompanyDAO;
import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;
import com.riti.cool.service.CompanyService;
import com.riti.cool.service.exception.AddCompanyException;
import com.riti.cool.service.exception.CompanyExistException;
import com.riti.cool.service.exception.UserUpdateException;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Resource
	private CompanyService companyService;

	/**
	 * 添加公司
	 * 
	 * @param userId
	 * @param company
	 * @return
	 */
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<User> addCompany(String userId, Company company) {
		User user = companyService.setUserCompany(userId, company);
		System.out.println(userId + "," + company);
		return new ResultCode<User>(user, "新建公司完成");
	}

	/**
	 * 获取公司
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getCompany", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<Company> getCompany(String userId) {
		System.out.println("getCompany: "+userId);
		Company company = companyService.getUserCompany(userId);
		System.out.println(company);
		return new ResultCode(company, "查询成功");
	}

	/**
	 * 获取公司
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/findCompany", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<Company>> findCompany(String companyName) {
		System.out.println("companyName: "+companyName);
		List<Company> companys = companyService.findCompany(companyName);

		return new ResultCode(companys, "查询成功");
	}

	// 更新用户信息失败
	@ExceptionHandler(UserUpdateException.class)
	@ResponseBody
	public ResultCode<String> handleUserUpdate(UserUpdateException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 保存公司失败
	@ExceptionHandler(AddCompanyException.class)
	@ResponseBody
	public ResultCode<String> addCompany(AddCompanyException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 重复公司信息
	@ExceptionHandler(CompanyExistException.class)
	@ResponseBody
	public ResultCode<String> companyExist(CompanyExistException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

}
