package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;

public interface CompanyService {
	/**
	 * 设置用户所在公司，添加公司信息
	 * @param userId
	 * @param company
	 * @return
	 */
	User setUserCompany(String userId, Company company);
	/**
	 * 获取用户公司信息
	 * @param userId
	 * @return
	 */
	Company getUserCompany(String userId);
	/**
	 * 依据公司名获取用户公司信息
	 * @param company
	 * @return
	 */
	List<Company> findCompany(String companyName);
	
}
